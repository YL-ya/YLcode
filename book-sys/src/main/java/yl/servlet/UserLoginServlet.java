package yl.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//设置请求编码，针对请求体，注意url中是没有效果的
        resp.setCharacterEncoding("UTF-8");//针对响应体设置编码
        resp.setContentType("text/html");//设置响应的数据格式，响应头content-type告诉浏览器怎么解析

        //前端抓包，看到有k=v这样的数据(url,请求体)，但是key一定要一致
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.printf("用户名=%s,密码=%s\n",username,password);

        PrintWriter pw=resp.getWriter();
        pw.print("登陆成功");
        pw.flush();
    }
}
