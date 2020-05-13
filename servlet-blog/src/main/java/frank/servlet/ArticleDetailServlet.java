package frank.servlet;

import frank.exception.ClientException;
import frank.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet("/articleDetail")
public class ArticleDetailServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //传过来的数据报有文章id的，在这里我们要获得他
        String id=req.getParameter("id");
        //为什么这里可以用该方法获得前端的数据，因为前端传过来的数据报里面是没有content-Type字段，而且参数是写在URL中的
        //但是前面的那个添加文章的报头里面添加了Content-type字段：application/json类型的，要用输入流进行转化

        //因为传进来的id可能是null
        Integer articleId;
        try {
            articleId=Integer.parseInt(id);
            //Integer articleId = Integer.parseInt(id);
            /*if(articleId==1){
                int i=11/0;
            }*/
            //return testData();//测试代码以后替换成数据库(根据文章id)查询文章的操作

        }catch (Exception e){
            throw new ClientException("001","请求参数错误：【id="+id+"】");
        }
        if(articleId==1){
            int i=11/0;
        }
        return testData();
    }

    public static Article testData(){
        Article article=new Article();
        article.setId(1);
        article.setTitle("好帅哦");
        article.setContent("计算机大法真是好，让人秃头，又费脑");
        article.setUserId(1);
        article.setCreateTime(new Date());
        return article;
    }
}
