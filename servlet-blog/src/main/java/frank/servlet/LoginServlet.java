package frank.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        HttpSession session=req.getSession();
        if(username!=null&&username.equals("admin")&&password!=null&&password.equals("123456")) {
            session.setAttribute("login",true);
            resp.sendRedirect("success.jsp");
        }else {
            resp.sendRedirect("failure.jsp");
        }
    }
}
