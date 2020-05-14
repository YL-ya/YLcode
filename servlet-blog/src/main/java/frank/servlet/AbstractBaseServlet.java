package frank.servlet;

import frank.exception.BaseException;
import frank.model.Result;
import frank.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

//父类写成抽象类，这样子类继承该父类，父类有的地方子类都有，然后子类将抽象方法自己重写
public abstract class AbstractBaseServlet extends HttpServlet {

    //统计访问量：用Map结构：会引起多线程安全;用ConcurrentMap即可，保证线程安全
    private static final ConcurrentMap<String ,Integer> MapCount=new ConcurrentHashMap<>();

    //高阶线程的Api:
    private static final ConcurrentMap<String, AtomicInteger> MapCount1=new ConcurrentHashMap<>();


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
            if(e instanceof BaseException){
                //如果自定义的异常的话，就可以区分是后端报错
                BaseException be=(BaseException) e;
                result.setMessage("错误码："+be.getCode()+"，错误信息，"+be.getMessage());
            }else {
                result.setMessage("服务器异常，未知错误");

            }
            //result.setMessage(e.getMessage());

            StringWriter sw=new StringWriter();//这里可以获得堆栈信息的字符串
            PrintWriter epw=new PrintWriter(sw);
            e.printStackTrace(epw);
            result.setStackTrace(sw.toString());//堆栈信息
        }
        PrintWriter pw=resp.getWriter();//resp的输出流；往客户端打入数据
        pw.println(JSONUtil.serialize(result));//将对象弄成json格式的字符串进行打印
        pw.flush();

        /*System.out.println("scheme:"+req.getScheme());//协议号:http
        System.out.println("servletPath:"+req.getServletPath());//请求servlet的路径:/articleList
        System.out.println("contentPath:"+req.getContextPath());//应用部署的路径（上下文路径）:/blog
        System.out.println("RequestURL:"+req.getRequestURL());//请求的全路径:http://localhost:8080/blog/articleList
        System.out.println("RequestURI:"+req.getRequestURI());//ContextPath+ServletPath:/blog/articleList
        System.out.println("pathInfo:"+req.getPathInfo());//null*/
        //还有没有线程安全的问题：
        //ConcurrentMap只是put和get方法是线程安全的:也就是说整块代码是不具有安全的；所以整段代码要进行加锁
        //方法1：通过synchronized保证代码块的原子性
        synchronized (MapCount) {
            String path = req.getServletPath();
            Integer count = MapCount.get(path);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            MapCount.put(path, count);
        }

        //方法2：通过AtomicInteger结合ConcurrentHashMap来保证线程安全：效率比较高
        String path = req.getServletPath();
        AtomicInteger count = MapCount1.putIfAbsent(path,new AtomicInteger());
        count.incrementAndGet();//进行++操作(线程安全的)
    }
    public abstract Object process (HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
