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
    //为了确保安全进入：1：获取状态：
    Boolean login=(Boolean)session.getAttribute("login");
    if(login==null||!login){
        //如果键值对不满足，直接返回什么都不会显示
        return;
    }

    //如果键值对匹配对了话，就继续
%>
    This is a success page!!!<br>
</body>
</html>
