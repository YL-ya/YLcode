<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/16
  Time: 下午 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%=session.isNew()%><!--是否第一次登陆--><br>
<%=session.getId()%>
<%=session.getCreationTime()%>
