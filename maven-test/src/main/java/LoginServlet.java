import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login",loadOnStartup = 0)//相当于跳转后的页面;
// 当loadOnStartUp=0就是启动Tomcat的时候就加载servlet对象
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码及响应的编码，响应的数据类型
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        // 假如请求数据为username=xxx&password=xxx
        String username = req.getParameter("username");
        try{
            Integer.parseInt(username);
        }catch (Exception e){
            resp.setStatus(400);
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
        String password = req.getParameter("password");


        //request.getServletPath():获取的是URL的路径：/login
        //request.getContextPath():获取的是项目部署名：/test
        System.out.println("servletPath"+req.getServletPath()+"contextPath"+req.getContextPath());
        System.out.printf("username=%s,password=%s\n",username,password);

//        PrintWriter pw = resp.getWriter();//保存输出流
        // 1:登录成功，重定向到首页
        if("abc".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)){//忽略大小写
//               pw.println("<p>登录成功</p>");

            // request.getSession(boolean create)：
            // 从请求对象获取一个session对象，如果获取不到，根据create决定是否创建
            // create=true，创建一个session对象，create=false，不创建，返回null
            // request.getSession()=request.getSession(true):无参情况下默认为true
            HttpSession session=req.getSession();//获取一个session对象
            session.setAttribute("user", "username="+username);//服务器保存相关键值对
            resp.sendRedirect(req.getContextPath() + "/main.html");//响应该客户端并且携带key

            
            //resp.sendRedirect(req.getContextPath()+ "/main.html");//重定向地址
            //resp.sendRedirect("https://www.baidu.com");
       //2:登录不成功，转发到错误页面
        }else {
 //           pw.println("<p>用户名密码错误，登录不成功</p>");
            req.getRequestDispatcher("/error.html").forward(req,resp);//转发
        }
        //pw.flush();
    }
}

        /*// 假如请求数据为username=xxx&password=xxx
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // request.getServletPath()获取uri的路径：/login
        // request.getContextPath()获取项目的部署名：/test
        System.out.println("servletpath:"+req.getServletPath()+", contextpath:"+req.getContextPath());
        System.out.printf("username=%s, password=%s\n", username, password);

//        PrintWriter pw = resp.getWriter();
        // 登录成功，重定向到首页
        if("abc".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)){
//            pw.println("<p>登录成功</p>");
            // request.getSession(boolean create)：
            // 从请求对象获取一个session对象，如果获取不到，根据create决定是否创建
            // create=true，创建一个session对象，create=false，不创建，返回null
            // request.getSession()=request.getSession(true)
            HttpSession session = req.getSession();
            session.setAttribute("user", "username="+username);
            resp.sendRedirect(req.getContextPath() + "/main.html");
//            resp.sendRedirect("https://www.baidu.com");
        }else{// 登录不成功，转发到错误页面
//            pw.println("<p>用户名密码错误，登录不成功</p>");
            req.getRequestDispatcher("/error.html").forward(req, resp);
        }
//        pw.flush();
    }
}
*/