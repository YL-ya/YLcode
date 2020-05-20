<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/15
  Time: 下午 04:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
    <title>这是一个简单的注册界面</title>
</head>
<body>
    <h1>请注册!</h1>
    <form action="reg" ><!--method="POST"-->
        用户名：<input name="username" type="text" placeholder="请输入用户名"><br>
        密码：<input name="password" type="password" placeholder="请输入密码"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
