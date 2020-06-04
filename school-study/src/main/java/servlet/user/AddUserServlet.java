package servlet.user;

import dao.UserDAO;
import xpu.vo.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/add")
//控制用户的插入：
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out=resp.getWriter();
        String username=req.getParameter("username");
        if(username==null||username.equals("")){
            out.print("用户名不能为空！！");
            out.print("go back");
        }
        String password=req.getParameter("password");
        UserVO user=new UserVO();
        user.setUsername(username);
        user.setPassword(password);//注入属性

        //然后调用dao将用户写入数据库
        UserDAO userDAO=new UserDAO();
        //这里已进行实例化的时候，就已将连接好了数据库，调里面的写入方法即可写入

        //当插入用户的时候，先进行判断用户存不存在：
        try {
            if(userDAO.exists(user.getUsername())){
                //说明用户已经存在
                out.print("用户已经存在，无法插入");
                out.print("go back");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //当用户不存在的时候直接插入：
        try {
            userDAO.Add(user);
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("添加用户失败");
            out.print("go back");
            out.close();
        }
    }
}
