package frank.servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/show")
class ShowTimesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Integer times = (Integer) context.getAttribute("times");
        if (times == null) {
            times = new Integer(1);
        } else {
            times = new Integer(times.intValue() + 1);
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out= response.getWriter();
        out.println("<html><head><title>");
        out.println("页面访问统计");
        out.println("</title></head><body>");
        out.println("当前页面被访问了");
        out.println("<font color=red size=20>"+times+"</font>次");
        context.setAttribute("times",times);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
