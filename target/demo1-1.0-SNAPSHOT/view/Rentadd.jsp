<%@ page import="dao.FactDao" %>
<%@ page import="entity.User" %>
<%@ page import="java.sql.SQLOutput" %><%--
  Created by IntelliJ IDEA.
  User: jas0n
  Date: 2021/7/15
  Time: 7:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>租赁新设备</title>
  <script type="text/javascript" src="../js/time.js" ></script>
  <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>租赁新设备</h1>

<form action="/Rent/RentManage" method="post">
  工厂名称：<input type="text" name="fname" required="required"><br/>
  用户编号：<input type="text" name="租用人" value="${thisuser.UID}" readonly><br/>
  设备编号：<input type="text" name="EID" required="required"><br/>
  到期时间：<input type="text" name="expiretime" required="required"><br/>
  <input type="hidden" name="method" value="adminadd"/>
  <input type="submit" value="提交新增"/>
</form>
</body>
</html>
