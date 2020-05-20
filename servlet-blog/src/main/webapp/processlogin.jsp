<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/15
  Time: 下午 04:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>

<!--这里就相当于用javabean创建了一个对象实例放在了session中-->
<jsp:useBean id="user" class="frank.javabean.UserBean" scope="session"/>

<jsp:setProperty name="user" property="uername" param="username"/>
<jsp:setProperty name="user" property="password" param="password"/>
<jsp:setProperty name="user" property="*"/>
<!--这里可以通过传入*实现自定义的绑定，前提条件就是名字的一致-->


    <%
    /*String username=request.getParameter("username");
    String password=request.getParameter("password");
    //这里可以 用javabean的动作标签实现
    */
    if(user.getUsername()!=null&&user.getPassword().equals("admin")&&user.getPassword()!=null&&user.getPassword().equals("123456")) {
        /*//标签实现转发：<!--全部满足的时候，jsp:forward page="success.jsp"/>才会返回到成功页面-->
        RequestDispatcher d=request.getRequestDispatcher("success.jsp");
        d.forward(request,response);//java脚本语言实现转发
*/

        //确保安全性：也就是不登陆，就不能直接桶url访问响应的网页:
        session.setAttribute("login",true);//将用户信息保存在里面，以后可以进行传递

        //java实现重定向：
        response.sendRedirect("success.jsp");


    }else {
       /* RequestDispatcher m=request.getRequestDispatcher("failure.jsp");
        m.forward(request,response);
        //标签实现转发：<!---否则转发到失败页面 jsp:forward page="failure.jsp"/>->*/


        response.sendRedirect("failure.jsp");//可以跳转到任何网站(新浪)，但是转发不行
    }
%>