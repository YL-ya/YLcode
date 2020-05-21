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
<jsp:setProperty name="user" property="*"/>
<%
    if(user.getUsername()!=null&&user.getPassword().equals("admin")&&user.getPassword()!=null&&user.getPassword().equals("123456")) {
        session.setAttribute("login",true);
        response.sendRedirect("success.jsp");
    }else {
        response.sendRedirect("failure.jsp");
    }
%>