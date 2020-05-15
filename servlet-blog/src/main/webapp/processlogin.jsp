<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/15
  Time: 下午 04:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    if(username!=null&&username.equals("admin")&&password!=null&&password.equals("123456")) {
        //标签实现：<!--全部满足的时候，jsp:forward page="success.jsp"/>才会返回到成功页面-->
        RequestDispatcher d=request.getRequestDispatcher("success.jsp");
        d.forward(request,response);//java脚本语言实现
    }else {
        RequestDispatcher m=request.getRequestDispatcher("failure.jsp");
        m.forward(request,response);
        //标签实现：<!---否则转发到失败页面 jsp:forward page="failure.jsp"/>->
    }
%>