<%--
  Created by IntelliJ IDEA.
  User: jas0n
  Date: 2021/7/17
  Time: 11:20 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<form action="/view/login" method="post">
    用户密码：<input type = "text" name="password" required="required"><br/>
    用户地址：<input type = "text" name="address" required="required"><br/>
    联系方式：<input type = "text" name="phonenumber" required="required"><br/>
    用户角色：<input type = "text" name="actor" required="required"><br/>

    <input type="hidden" name="method" value="add"/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
