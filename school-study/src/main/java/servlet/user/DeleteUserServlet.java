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

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
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

        //1：从前端获得用户名：因为是删除用户，只用根据用户名称进行删除即可
        String username=req.getParameter("username");
        if(username==null||username.equals("")){
            out.print("用户名为空");
            out.print("go back");
        }
        //String password=req.getParameter("password");

        //2：将其放入用户VO类
        UserVO user=new UserVO();
        user.setUsername(username);
        //user.setPassword(password);

        //3；进行相关的数据库操作：
        UserDAO userDAO=new UserDAO();

        try {
            if(!userDAO.exists(user.getUsername())){
                out.print("用户不存在，无法删除");
                out.print("go back");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            userDAO.Delete(user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("删除用户失败");
            out.print("go back");
            out.close();
        }
    }
}
