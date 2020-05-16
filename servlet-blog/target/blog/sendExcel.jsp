<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/16
  Time: 下午 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"  language="java" import="java.util.*" %>
<%
    response.setContentType("application/vnd.ms-excel");//因为Excel文件是以二进制进行读取的
    out.println("姓名\t成绩");
    out.println("张三\t90");
    out.println("李四\t80");
    out.println("平均\t=(90+80)/2");
%>
