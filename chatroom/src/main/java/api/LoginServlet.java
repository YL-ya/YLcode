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
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private Gson gson=new GsonBuilder().create();

    static class Request{
        public String name;
        public String password;
    }

    static class Response{
        public int ok;
        public String reason;
        public int userId;
        public String name;
        public String nickName;
    }

    //根据请求http请求方法不同，则设计不同的功能
    //doPost:进行登录
    //doGet:检测登录状态：比如有个页面，你已经登陆过了，此时刷新之后还是登录的状态(基于cookie/session来实现的)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Response response=new Response();
        try {
            //1:读取body中的数据
            String body= Util.readBody(req);
            //2:把读到的数据转成Request对象
            Request request=gson.fromJson(body,Request.class);
            //3:按用户名在数据库中查找，匹配密码是否正确
            UserDao userDao=new UserDao();
            User user=userDao.selectByName(request.name);
            //4:如果登录失败，则给出提示
            //  a)：用户名没查到登录失败
            //  b)：密码不匹配
            if(user==null||!request.password.equals(user.getPassword())){
                throw new ChatroomException("用户名或密码错误");
            }
            //5:如果登录成功，创建一个session对象
            HttpSession httpSession=req.getSession(true);
            httpSession.setAttribute("user",user);
            //"user"作为键值对的key;user作为键值对的value

            //6:登陆成功把结果写回到浏览器
            response.ok=1;
            response.name=user.getName();
            response.userId=user.getUserId();
            response.nickName=user.getNickName();
            response.reason="";
        } catch (ChatroomException | JsonSyntaxException e) {
            e.printStackTrace();
            response.ok=0;
            response.reason=e.getMessage();
        }finally {
            String jsonString=gson.toJson(response);
            resp.getWriter().write(jsonString);//将结果返回给客户端
        }
    }

    //检测登录状态功能
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response=new Response();
        try {
            //1:根据请求，查看该sessionId对应的session是否存在
            //  如果session不存在，就是登陆失败
            HttpSession httpSession=req.getSession(false);//false:表示如果不存在我们也不会创建session
            if(httpSession==null){
                //当返回结果是null的状态的话，就是session是不存在的
                throw new ChatroomException("当前未登录");
            }
            //存在：
            User user=(User) httpSession.getAttribute("user");
            //2:如果session存在，直接返回一个登陆成功即可
            response.ok=1;
            response.userId=user.getUserId();
            response.name=user.getName();
            response.nickName=user.getNickName();
            response.reason="";
        } catch (ChatroomException e) {
            e.printStackTrace();
            response.ok=0;
            response.reason=e.getMessage();
        }finally {
            resp.setContentType("application/json;charset=utf-8");
            String jsonString=gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
