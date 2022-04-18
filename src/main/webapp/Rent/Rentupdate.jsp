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
    <title>租赁信息修改</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>租赁信息修改</h1>
<form action="/Rent/RentManage" method="post">
    租赁编号(唯一标识，只读不可修改）：<input type="text" name="RID" value="${Rent.RID}" readonly/><br/>
    工厂名称：<input type="text" name="fname" value="${Rent.fname}" required="required"><br/>
    设备编号：<input type="text" name="EID" value="${Rent.EID}" required="required"><br/>
    到期时间：<input type="text" name="expiretime" value="${Rent.expiretime}" required="required"><br/>
    <input type="hidden" name="method" value="update"/>
    <input type="submit" value="提交修改"/>
</form>
</body>
</html>