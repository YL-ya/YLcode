package yl.servlet;

import yl.dao.UserDAO;
import yl.exception.BusinessException;
import yl.model.User;
import yl.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/login")
public class UserLoginServlet extends AbstractBaseServlet{

    //通过后台进行过滤器过滤
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //通过流进行解析：
        User user= JSONUtil.read(req.getInputStream(),User.class);//http请求解析的用户数据
        User queryUser= UserDAO.query(user);//通过请求的用户名密码在数据库中进行查询，获取用户
        if(queryUser==null){
            throw new BusinessException("000000","用户密码校验失败");
        }

        //不为空的话，就说明数据库中有
        HttpSession session=req.getSession();
        session.setAttribute("user",queryUser);
        return null;//响应成功
    }
}
