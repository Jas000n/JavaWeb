<%--
  Created by IntelliJ IDEA.
  User: jas0n
  Date: 2021/7/17
  Time: 11:12 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>云工厂登陆</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>

<body>
<h1>用户登陆</h1>
<div id="clock"></div>
<form action="/view/login" method="post">
    用户编号：<input type = "text" name="UID" required="required"><br/>
    用户密码：<input type = "password" name="password" required="required"><br/>

    <input type="hidden" name="method" value="login"/>
    <input type="submit" value="登陆"/>
</form>
<form action="/view/login" method="get">
    <input type="hidden" name="method" value="register"/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
