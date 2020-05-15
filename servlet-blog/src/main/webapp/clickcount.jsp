<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/15
  Time: 上午 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--this is a jsp comment--%>
<!--this is a html comment-->
<!--做一个网页计数器
    思路：定义一个变量，全局变量，每运行一次进行++就可以了-->

<%!
    //define a global varible
    int count=0;//别翻译到类的属性里面，因为实例化一次对象的时候，就已经被创建；
    // 并且一个jsp被访问很多人访问的时候只会创建一个实例
%>
<%
    count++;
    //方法1：out.print("You click "+count+" times");




    /*int count=0;
    count++;
    out.print("You click "+count+" times");*/
    //这样做出来的代码，点击次数一直都是1，因为每次点击并执行该段代码的时候，count=0;所以我们的设置成全局变量
%>
You clicked <%=count%> times!