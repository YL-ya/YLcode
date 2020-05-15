<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/15
  Time: 下午 01:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<!--errorPage="error.jsp":指定发生异常后跳转的页面-->
<body>
    <%
        /*String s=null;
        int i=s.length();//本句话将发生空指针异常*/

        out.print(5/0);
    %>
</body>

