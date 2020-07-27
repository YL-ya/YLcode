package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.MessageDao;
import dao.UserDao;
import model.Message;
import model.MessageCenter;
import model.User;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

//用来实现websocket接口
//此处的userId变量，客户端连接的时候，具体提交的userId都有差异
//服务器需要获取到具体的userId是啥，
@ServerEndpoint(value="/message/{userId}")
public class MessageAPI {
    private Gson gson=new GsonBuilder().create();

    //是通过用户连接的url中获取到的
    private int userId;

    //建立连接时，要知道用户的id,(将建立连接的用户加入到在线用户列表中)通过ws这个url传给服务器的
    //服务器获取这个参数的时候，就使用注释的写法
    @OnOpen
    //1:建立连接的时候将用户放进在线用户列表中
    public void onOpen(@PathParam("userId") String userIdstr, Session session) throws IOException {
        //1:获取到userId
        this.userId=Integer.parseInt(userIdstr);
        System.out.println("连接建立："+userId);

        //2:把该用户加入到在线用户的列表中，
        MessageCenter.getInstance().addOnlineUser(userId,session);

        //3:用户建立连接进行登录的时候，获取历史消息，并直接转发个该用户
        UserDao userDao=new UserDao();
        User user=userDao.selectById(userId);
        Timestamp lastLogout=user.getLastLogout();
        MessageDao messageDao=new MessageDao();
        List<Message> messages=messageDao.selectByTimeStamp(lastLogout,new Timestamp(System.currentTimeMillis()));
        //将时间段中的历史信息拉出来
        for(Message message:messages){
            String jsonString=gson.toJson(message);
            session.getBasicRemote().sendText(jsonString);
        }
    }

    //2:断开连接的时候就将用户从在线列表中删除
    @OnClose
    public void onClose(){
        System.out.println("连接断开："+userId);
        //把用户从在线列表中删除
        MessageCenter.getInstance().delOnlineUser(userId);
    }

    //3:出现错误的话，也将用户从在线列表中删除
    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("连接出现错误："+userId);
        error.printStackTrace();
        MessageCenter.getInstance().delOnlineUser(userId);
    }

    //4:
    @OnMessage
    public void onMessage(String request,Session session) throws InterruptedException {
        System.out.println("收到消息!"+userId+": "+request);
        //1:解析message格式，收到的request对象应该是一个json格式的字符串
        Message message=gson.fromJson(request,Message.class);
        //2:把消息的发送时间填写一下
        message.setSendTime(new Timestamp(System.currentTimeMillis()));
        //3:把消息写入到消息中心去
        MessageCenter.getInstance().addMessage(message);
        //4:把这个消息写入数据库
        MessageDao messageDao=new MessageDao();
        messageDao.add(message);
    }
}
