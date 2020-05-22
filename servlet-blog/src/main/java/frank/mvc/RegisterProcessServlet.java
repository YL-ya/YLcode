package frank.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegisterProcessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        //从客户端的来的信息存放在用户的对象里面：
        UserVO user=new UserVO();
        user.setUsername("username");
        user.setPassword("password");

        //然后在用DAO存放在数据库里面即可：
        /*PrintWriter out=resp.getWriter();*/
        UserDAO dao=new UserDAO();
        if(dao.save(user)==1){
            /*out.println("插入数据库成功了");*/
            resp.sendRedirect("success.jap");
        }else {
            /*out.println("插入数据库失败了");*/
            resp.sendRedirect("failure.jap");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
