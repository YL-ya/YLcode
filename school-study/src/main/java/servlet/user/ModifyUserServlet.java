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

@WebServlet("/modify")
public class ModifyUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/heml;charset=UTF-8");
        PrintWriter out=resp.getWriter();

        String name=req.getParameter("modify");//单击了修改用户
        if(name!=null){
            //说明单击了，要进行修改操作：
            String username=req.getParameter("modifyName");
            if(username==null||username.equals("")){
                out.print("用户名为空");
                out.print("go back");
            }
            String password=req.getParameter("password");

            UserVO user=new UserVO();
            user.setUsername(username);
            user.setPassword(password);

            UserDAO userDAO=new UserDAO();
            try {
                userDAO.Update(user);
            } catch (SQLException e) {
                e.printStackTrace();
                out.print("修改失败："+e.getMessage());
                out.print("go back");
                return;
            }

        }
        out.print("修改成功！");
        out.print("go back");
        out.close();
    }
}
