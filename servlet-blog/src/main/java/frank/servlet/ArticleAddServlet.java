package frank.servlet;

import frank.model.Article;
import frank.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

//添加新文章到数据库里面：添加接口；因为好多操作都一样，所以可以考虑继承
@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        /*1：获得数据格式，以前获得前端给过来的数据密码和iD是用req.getParameter()获得的字符串
        *    现在是文章，要用输入流进行获得
        * 2：获得InputStream输入流(json格式的字符串)后解析成java对象*/

        //文章添加，请求数据中包含title,content,userAccount
        InputStream is=req.getInputStream();//这里获得的是输入流(io流，也就是要将IO流转成字符串)

        //http请求发过来的Content-Type为application/json,求青提李曼是json的字符串，我们要反序列化为java对象
        //需要检查json字符串的键值对，必须和java类的属性保持一致，
        //也就是能够进行匹配(java对象里面的属性只能多不能少)，如果json里面的字段，java里面没有就会报错
        Article article= JSONUtil.deserialize(is, Article.class);

        //模拟数据库插入数据操作
        System.out.println("=============================\n"+article);
        return null;
    }
}
