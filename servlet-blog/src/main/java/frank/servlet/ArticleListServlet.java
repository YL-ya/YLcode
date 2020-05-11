package frank.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/articleList")//由jsp动态发起的javax请求到该页面

//1：页面是一个get请求，所以重写doGet()就行了
public class ArticleListServlet extends HttpServlet {
    @Override
    //1：设置一些头部信息
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注意：在servlet里面要设置统一的编码：
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");//设置请求/响应的编码格式
        resp.setContentType("application/json; charset=UTF-8");
        //在这里设置响应内容的格式：json格式的字符串类型
    }
    //2：数据的操作：
}
