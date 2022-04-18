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
    <title>用户信息修改</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<form action="/User/UserManage" method="post">
    用户编号(唯一标识，只读不可修改）：<input type="text" name="UID" value="${User.UID}" readonly/><br/>
    用户密码：<input type="text" name="password" value="${User.password}" required="required"><br/>
    用户地址：<input type="text" name="address" value="${User.address}" required="required"><br/>
    联系方式：<input type="text" name="phonenumber" value="${User.phonenumber}" required="required"><br/>
    用户角色：<input type="text" name="actor" value="${User.actor}" required="required"><br/>
    <input type="hidden" name="method" value="update"/>
    <input type="submit" value="提交修改"/>
</form>
</body>
</html>