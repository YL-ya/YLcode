package frank.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sc")
public class SchoolCount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw=resp.getWriter();

        //session方法：
        /*思路：
         * 1：先进行取，如果不存在的话，直接输出1，并将1赋值到session中去
         * 2：然后在进行取得时候，会在上面的而基础上会进行++操作
         * 原理：session会帮助我们暂时保管一段时间变量的状态
         * 注意：每个客户端有自己session，如果换个浏览器将会从1开始*/
        /*HttpSession session=req.getSession();//在servlet中的session一定要进行定义
        Integer count=(Integer) session.getAttribute("counter");
        if(count==null){//这里是对象形式的，所以是null
            session.setAttribute("counter",1);
            pw.println("YOU CLICKED: "+1);//这里是第一次，检测到是null的情况，先给他放个初值1
        }else {
            //当他不是null的时候，也就是第二次或者其他次进行访问的话，直接++就好了，因为session会帮我们保留一定的时间
            count++;
            session.setAttribute("counter",count);
            pw.println("YOU CLICKED: "+count);
        }*/

        //application方法：全局共享的，也就是所有客户端共享的  
        ServletContext application=this.getServletContext();
        Integer count=(Integer) application.getAttribute("counter");
        if(count==null){//这里是对象形式的，所以是null
            application.setAttribute("counter",1);
            pw.println("YOU CLICKED: "+1);//这里是第一次，检测到是null的情况，先给他放个初值1
        }else {
            //当他不是null的时候，也就是第二次或者其他次进行访问的话，直接++就好了，因为session会帮我们保留一定的时间
            count++;
            application.setAttribute("counter",count);
            pw.println("YOU CLICKED: "+count);
        }
        /*int count=0;
        count++;//这里是局部变量，是不会进行累加的
        pw.println("You clicked: "+count);*/
        pw.flush();
        pw.close();
    }
}
