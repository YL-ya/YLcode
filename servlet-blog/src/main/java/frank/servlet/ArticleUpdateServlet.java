package frank.servlet;

import frank.model.Article;
import frank.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //文章修改，请求数据中包含id,title,content
        InputStream is=req.getInputStream();
        Article article= JSONUtil.deserialize(is,Article.class);

        //模拟修改数据：
        System.out.println("=======================\n"+article);
        return null;//解析数据没问题，默认就是成功操作，直接返回一个null
    }
}
