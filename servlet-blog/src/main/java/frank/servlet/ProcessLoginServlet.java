package frank.servlet;

import frank.javabean.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class ProcessLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        UserBean user=new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        HttpSession session=req.getSession();
        session.setAttribute("user",user);
        if(user.getUsername()!=null&&user.getUsername().equals("admin")&&
                user.getPassword()!=null&&user.getPassword().equals("123456")){
            session.setAttribute("login",true);
            resp.sendRedirect("success.jsp");//重定向
        }else {
            RequestDispatcher d=req.getRequestDispatcher("failure.jsp");
            d.forward(req,resp);//转发实现
        }
    }
}
