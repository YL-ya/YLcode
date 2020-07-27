package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

//管理消息和用户列表，实现消息转发
//这个类作为我们的单例即可(因为用户列表只用保存一个即可，不用创建大量的实例进行保存)
public class MessageCenter {
    private volatile static MessageCenter instance=null;

    public static MessageCenter getInstance(){
        if (instance==null) {
            synchronized (MessageCenter.class) {
                if (instance == null) {
                    instance = new MessageCenter();
                }
            }
        }
        return instance;
    }

    //里面包含两个重要的数据结构：
    //1：保存消息的队列(阻塞队列)：相当于生产者
    private BlockingQueue<Message> messages=new LinkedBlockingQueue<>();

    //2：保存在线用户列表(哈希表)：相当于消费者
    /*integer:保存的是用户id
    * session:保存的登录信息
    * ConcurrentHashMap和hashtable(比较底层)都是线程安全的*/
    private ConcurrentHashMap<Integer, Session> onlineUsers=new ConcurrentHashMap<>();


    //3：实现几个操作这两结构的方法
    //3.1:考虑用户上线下线的问题：当用户上线的时候，将信息存放在哈希表里
    public void addOnlineUser(int userId,Session session){
        onlineUsers.put(userId,session);
    }

    //3.2:用户下线
    public void delOnlineUser(int userId){
        onlineUsers.remove(userId);
    }

    //4:新增消息
    public void addMessage(Message message) throws InterruptedException {
         messages.put(message);
    }

    //接下来的代码就是创建线程实现生产者消费者模型
    //也就是创建一个线程一直扫描消息的队列，把里面存的消息转发给所有的在线用户
    //在构造MessageCenter的实例的时候，就启动这个线程
    //5:实现转发逻辑的核心代码
    private MessageCenter(){
        Thread t=new Thread(){
            @Override
            public void run() {
                Gson gson=new GsonBuilder().create();
                while (true){
                    try {
                        //1:从队列中取消息(服务器的websocket接口收到数据时，就存放在这个队列中)
                        //  如果队列为空的时候，此时的take就会阻塞，一直阻塞到队列中有消息的存在的时候唤醒
                        Message message=messages.take();
                        //2:获得消息之后，将消息转成json字符串
                        String jsonString=gson.toJson(message);
                        //3:遍历我们的在线用户列表，把我们的额消息转发给每个用户
                        for(ConcurrentHashMap.Entry<Integer,Session> entry:onlineUsers.entrySet()){
                            //在用户列表中获得Session然后进行每个的转发、
                            // (websocket内置对象session，只要有用户建立连接，就自动会创建session对象)
                            //服务器收到一条消息，就会转发N次(在线用户数目)
                            Session session=entry.getValue();//获得session对象
                            session.getBasicRemote().sendText(jsonString);
                        }
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        t.start();
    }
}
