<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2020/5/7
  Time: 下午 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <link href="static/css/app.css" rel="stylesheet"><!--样式：css文件，可以渲染背景等或者字体大小-->
    <!-- jQuery --><!--客户端编码的基本认-->
    <script type="text/javascript" src="static/jquery/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {//绑定页面加载事件，在加载完之后执行
            //alert("jsp文件加载完成")
            $.ajax({//提交给后台ajax请求
                url:"login",//请求的路径
                type:"post",//请求的方法
                contentType:"application/json",//请求的数据格式
                data:{"username":"abc","password":"123"},//请求的数据
                dataType:"json",//响应的数据格式
                success:function (data) {//返回的状态码是200，也就是请求成功的状态时，条用这个函数
                } 
            });
            $("#btn").click(function () {//绑定按钮的点击事件
                //alert("点击按钮");
                //在这里紫萼的话就是，点击按钮，来请求的服务的代码
            });
        });
    </script>
</head>
<body>

<!-- 假如提交到后台的URL是http://localhost:8080/blog-->
<!--action为login，访问的是：http://localhost:8080/blog/jsp/login：是以当前界面作为相对路径，加上请求路径-->
<!--action为/login,访问的是：http://localhost:8080/login-->
<!--配置jsp变量，及base标签，可以解决路径问题：action为login，访问就是正确的路径-->
    <form action="login">
        <input type="text" name="username" placeholder="请输入用户名">
        <input type="password" name="password" placeholder="请输入密码">
        <input type="submit" value="提交">
    </form>
    <input id="btn" type="button" value="点击观看事件">

</body>
</html>
