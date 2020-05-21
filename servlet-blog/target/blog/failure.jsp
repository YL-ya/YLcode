<%@ page import="frank.javabean.UserBean" %><%--
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

<!--这里就是jsp(代码)+javabean(数据)：可以节省很多脚本步骤-->
<%=((frank.javabean.UserBean)session.getAttribute("user")).getUsername()%>
<jsp:useBean id="user" scope="session" class="frank.javabean.UserBean"/>
<jsp:getProperty name="user" property="username"/><br/>
<jsp:getProperty name="user" property="password"/>
</body>





















</html>
