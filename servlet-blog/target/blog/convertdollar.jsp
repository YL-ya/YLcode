<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/14
  Time: 下午 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form>
    Please input a data:<input name="dollar" type="text"><br>
    <input type="submit" value="提交" placeholder="请输入一个数据">
</form>
<%
    String d=request.getParameter("dollar");
    if(d!=null){
        Double d1=Double.parseDouble(d);//将字符串转成double型的数据
        Double rm=d1*7.1;
        out.print(rm);
    }
%>