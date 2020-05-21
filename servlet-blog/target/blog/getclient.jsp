<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/21
  Time: 下午 05:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    客户端请求方法：<%=request.getMethod()%><br/>
    客户端类型：<%=request.getHeader("User-Agent")%><br/>
    客户端的IP地址：<%=request.getRemoteAddr()%>
</body>
</html>
