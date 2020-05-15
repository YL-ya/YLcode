<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/15
  Time: 下午 01:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!--isErrorPage="true":这个将会拿到java中的Exception对象-->
对不起，系统崩溃了！！！<br>
<%=exception%>
<body>
    <%

        /*StackTraceElement a[]=exception.getStackTrace();//拿到异常对象的相关信息
        out.print("出错原因是："+exception+"<br>");
        out.print("出错的文件："+a[0].getFileName()+"<br>");
        out.print("出错的方法名："+a[0].getMethodName()+"<br>");
        out.print("出错的行号是："+a[0].getLineNumber()+"<br>");*/
    %>
</body>