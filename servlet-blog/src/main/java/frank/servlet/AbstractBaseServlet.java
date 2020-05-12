package frank.servlet;

import frank.model.Result;
import frank.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

//父类写成抽象类，这样子类继承该父类，父类有的地方子类都有，然后子类将抽象方法自己重写
public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");

        Result result=new Result();
        try {
            Object data=process(req,resp);
            /*List<Article> articles = testData();*/
            result.setSuccess(true);
            result.setData(data);
        }catch (Exception e){
            result.setMessage(e.getMessage());

            StringWriter sw=new StringWriter();//这里可以获得堆栈信息的字符串
            PrintWriter epw=new PrintWriter(sw);
            e.printStackTrace(epw);
            result.setStackTrace(sw.toString());//堆栈信息
        }
        PrintWriter pw=resp.getWriter();//resp的输出流；往客户端打入数据
        pw.println(JSONUtil.serialize(result));//将对象弄成json格式的字符串进行打印
        pw.flush();
    }
    public abstract Object process (HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
