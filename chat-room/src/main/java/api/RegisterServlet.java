package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import dao.UserDao;
import model.User;
import model.Util;
import util.ChatroomException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;

/*每个接口都对应一个具体的请求，并且要生成对应的响应
* 1：如果是http的接口，就使用servlet进行实现
* 2：如果是websocket的接口，就使用websocket进行实现*/

//实现的是注册功能
public class RegisterServlet extends HttpServlet {
    //Gson实例化的固定写法
    private Gson gson=new GsonBuilder().create();

    //这个类以内部类的方式来组织，这个Request类只针对RegisterServlet类使用的
    //其他的Servlet对应的request类可能结构是不一样的
    //从body的json中转化过来的
    static class Request{
        public String name;
        public String password;
        public String nickName;
    }

    //响应的数据内容
    //要把这个对象再转回成json字符串，并写回给客户端
    static class Response{
        public int ok;
        public String reason;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //JSON结构的响应，是http协议响应的一部分(body)
        Response response=new Response();

        //1:读取body中的信息(json格式字符串)
        try {
            String body= Util.readBody(req);
        //2:把json数据转成java中的对象
            //  创建一个request类来表示这次的请求的结构
            //  需要把body=>request 对象，此处最好借助第三方库来完成(JSON的第三方库有很多，fastjson,jackson...)
            //  在这使用的是GSON(Google搞的一个库)

            //把json字符串转成java对象
            //body：JSON格式的字符串
            //Request.class：类对象(此处就需要通过这个类对象来告知gson库(反射机制)，你要把字符串转成什么对象)
            Request request=gson.fromJson(body,Request.class);
        //3:在数据库中查一下看一下是否已经存在了，如果存在的话，就注册失败
            UserDao userDao=new UserDao();
            User existUser=userDao.selectByName(request.name);
            if(existUser!=null){
                //说明存在
                throw new ChatroomException("用户名已经存在");
            }
        //4:成功的话，将心得用户名密码插入到构造的User对象，并插入到数据库中
            User user=new User();
            //以下三个内容是用户在客户端进行输入的
            user.setName(request.name);
            user.setPassword(request.password);
            user.setNickName(request.nickName);
            userDao.add(user);
        //5:返回一个注册成功的响应结果
            response.ok=1;
            response.reason="";//成功是不进行响应的
        } catch (ChatroomException | JsonSyntaxException e) {
            e.printStackTrace();
            response.ok=0;
            response.reason=e.getMessage();//获取到异常信息并打印(也就是刚开始抛出异常的时候的信息)
        }finally {
            //处理响应的逻辑
            //1:body的数据格式:常见的text/html;image/png;text/css;application/javaScript;application/json
            resp.setContentType("application/json; charset=utf-8");
            String jsonString=gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
