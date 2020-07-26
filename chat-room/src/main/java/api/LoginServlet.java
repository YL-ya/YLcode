package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1:读取body中的数据
        //2:把读到的数据转成Request对象
        //3:按用户名在数据库中查找，匹配密码是否正确
        //4:如果登录失败，则给出提示
        //5:如果登录成功，创建一个session对象
        //6:把结果写回到浏览器
    }
}
