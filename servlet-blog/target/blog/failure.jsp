<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/7
  Time: 下午 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    //在进行访问之前进行判断一下身份：
    Boolean login=(Boolean) session.getAttribute("login");
    if(login==null||login==false){
        return;//直接返回什么信息都没有
    }
%>
    this is a failure page!!!
</body>
</html>
