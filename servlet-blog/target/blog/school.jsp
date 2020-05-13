<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/13
  Time: 下午 08:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println(new java.util.Date());//在jsp找那个简单的java程序称作为：java脚本程序
    //脚本：不是独立的，只是网页的一部分

    /*这里是服务器程序
    * 首先该程序要在服务器运行
    * 结果用usp协议送给客户端*/

    //运行结果：Wed May 13 20:47:19 CST 2020
%>

<script>
    //javaScript：客户端脚本程序
    document.write(new Date())
    /*这里是客户端程序
    * 当浏览器请求的时候，该段会原封不动的送到客户端不执行
    * 然后是浏览器去运行*/
    //运行结果：Wed May 13 2020 20:47:19 GMT+0800 (中国标准时间)
</script>


</body>
</html>
