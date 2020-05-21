<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/21
  Time: 下午 06:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int n = 0;
    String counter = (String)application.getAttribute("counter");
    if(counter != null){
        n = Integer.parseInt(counter);
    }
    if(session.isNew())
        ++n;
%>
这是第<%=n%>个访问者
<%
    counter = String.valueOf(n);
    application.setAttribute("counter", counter);
%>
</body>
</html>
