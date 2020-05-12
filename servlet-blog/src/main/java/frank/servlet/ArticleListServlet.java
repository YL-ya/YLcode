package frank.servlet;

import frank.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/articleList")//由jsp动态发起的javax请求到该页面

//1：页面是一个get请求，所以重写doGet()就行了
public class ArticleListServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return testData();
    }//这里是通过设计模式(模板模式)改造的子类

    //使用到了：模板设计模式：父类定义统一的模板方法，方法中根据逻辑调用子类重写的方法
    //类似HttpServlet中的service方法就是模板方法，doGet/doPost就是子类中重写的方法

   /* @Override
    //1：设置一些头部信息
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注意：在servlet里面要设置统一的编码：
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");//设置请求/响应的编码格式
        resp.setContentType("application/json; charset=UTF-8");
        //在这里设置响应内容的格式：json格式的字符串类型

        //一：目的是：返回的是和前端代码约定好的统一的返回的json数据格式
        Result result=new Result();
        //在这里将下面的那个返回作为响应
        try {
            //1：正常返回业务数据：成功的话，直接返回Result对象，并把那个里面的相应属性设置成该设置的值
            List<Article> articles = testData();//这到时改成数据库(那种操作)查询的那种就好了
            result.setSuccess(true);//因为默认为false
            result.setData(articles);
        }catch (Exception e){
            //2：捕获到异常：需要设置我们前端的错误信息和堆栈信息：
            //失败同样返回的是result对象，然后在该字段里面这只一些异常信息
            result.setMessage(e.getMessage());

            StringWriter sw=new StringWriter();//这里可以获得堆栈信息的字符串
            PrintWriter epw=new PrintWriter(sw);
            e.printStackTrace(epw);
            //这三句话的意思是，打印的堆栈信息到输出流里面去，然后在打印到SW里面去

            result.setStackTrace(sw.toString());//堆栈信息
        }
        PrintWriter pw=resp.getWriter();//resp的输出流；往客户端打入数据
        pw.println(JSONUtil.serialize(result));//将对象弄成json格式的字符串进行打印
        pw.flush();
        //页面报错，但是咱们的文章列表已经返回了，只是页面(前端)没有解析出来(前端代码解析有问题)
    } */

    //2：数据的操作：模拟不处理请求，只处理响应：给一些模拟数据：页面需要的文章列表，页面返回的是ArticleList类型
    //在这里先构造一下，模拟数据；然后在doGet方法中以json格式响应
    public static List<Article> testData(){
        //测试数据：
        List<Article> articles=new ArrayList<>();
        Article article=new Article();
        article.setId(1);
        article.setTitle("好帅哦");
        article.setContent("计算机大法真是好，让人秃头，又费脑");
        article.setUserId(1);
        article.setCreateTime(new Date());
        Article article1=new Article();
        article1.setId(2);
        article1.setTitle("好丑哦");
        article1.setContent("医学大法真是好，让人秃头，又费脑");
        article1.setUserId(1);
        article1.setCreateTime(new Date());
        articles.add(article1);
        articles.add(article);
        return articles;
    }
}
