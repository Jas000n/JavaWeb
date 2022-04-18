<%--
  Created by IntelliJ IDEA.
  User: jas0n
  Date: 2021/7/15
  Time: 7:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户添加</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<form action="/User/UserManage" method="post">
    用户密码(8位密码）：<input type = "text" name="password" required="required"><br/>
    用户地址：<input type = "text" name="address" required="required"><br/>
    联系方式(8位联系方式)：<input type = "text" name="phonenumber" required="required"><br/>
    用户角色：<input type = "text" name="actor" required="required"><br/>

    <input type="hidden" name="method" value="add"/>
    <input type="submit" value="提交新增"/>
</form>
</body>
</html>
