package test;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;

//服务器处理连接的代码
@ServerEndpoint(value="/websocketTest")
//注解中修饰指定的类，同时在注解中使用value参数来指定一个具体的路径
//后续的HTML页面就可以通过这个路径来访问服务器

//这个注解的功能就类似于web.xml中配置的映射关系：
//                          通过一个路径跟类进行关联
public class websocketDemo {

    /*服务器的核心方法：不需要用户手动来调用，是服务器自动调用的，类似于Servlet里面的doGet和doPost方法一样*/
    /*websocket(消息推送) 连接建立成功之后，谁主动发消息均可(和之前的http协议，差异很大)
    * http协议只能是客户端主动给服务器发送，websocket弥补了这个缺点*/
    @OnOpen
    public void onOpen(Session session){//和HTTPSession(servlet中用到的session类)
                                        // 是不同的对象，但是起到的作用是类似的
        //将会在客户端建立连接的时候调用,由服务器自动维护一个session(餐桌)
        System.out.println("建立连接");


        //创建一个专门的线程，来源源不断的写回数据
        Thread t=new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        session.getBasicRemote().sendText("客户端你好"+new Date());
                        Thread.sleep(1000);
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    @OnClose
    public void onClose(){
        //客户端断开连接池调用
        System.out.println("断开连接");
    }

    @OnMessage
    //服务器收到客户端发的信息，就会触发onMessage函数
    public void onMessage(String message,Session session) throws IOException {
        //在服务器收到客户端的请求时进行调用
        System.out.println("收到消息"+message);

        //当收到消息时，就给客户端返回一个数据
        session.getBasicRemote().sendText("好的，我收到了");

    }

    public void onError(Session session,Throwable error){
        //连接意外终止是就会调用onError方法(比如网断了)
        System.out.println("连接出现错误");
        error.printStackTrace();
    }

}
