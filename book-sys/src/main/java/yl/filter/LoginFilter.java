package yl.filter;

//用来过滤登录的用户：使用的是过滤器

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")//模糊地址，所有请求来了都的进行过滤
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //ServletHttp有很多种，httpservlet只是其中的一个
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        String uri=req.getServletPath();

        //放行：
        if("/login.html".equals(uri) || uri.startsWith("/public/") ||
                uri.startsWith("/static/")||"/user/login".equals(uri)){
            filterChain.doFilter(servletRequest,servletResponse);//放行操作
        }else{
            //敏感资源
            HttpSession session=req.getSession(false);//当不满足条件的时候，不会新创建session
            if(session==null){
                //说明没有登录，不让访问敏感资源，需要跳转到登录页面，使用绝对路径
                String schema=req.getScheme();//http
                String host=req.getServerName();//服务器ip和域名
                int port=req.getServerPort();//服务器的端口号
                String contextPath=req.getContextPath();//项目部署名
                HttpServletResponse response=(HttpServletResponse) servletResponse;
                
                //拼接的绝对路径：
                String basePath= schema+"://"+host+":"+port+contextPath;
                //重定向：
                response.sendRedirect(basePath+"/public/index.html");
                return;
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }
        
    }

    @Override
    public void destroy() {

    }
}
