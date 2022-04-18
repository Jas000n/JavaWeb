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
    <title> 订单信息修改</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<h1>订单信息修改</h1>
<body>
<form action="/Order/OrderManage" method="post">
    订单编号(唯一标识，只读不可修改）：<input type="text" name="OID" value="${Order.OID}" readonly/><br/>
    竞标状态：<input type="text" name="status" value="${Order.status}" required="required"><br/>
    到期时间：<input type="text" name="duetime" value="${Order.duetime}" required="required"><br/>
    采购数量：<input type="text" name="quantity" value="${Order.quantity}" required="required"><br/>
    顾客编号：<input type="text" name="UID" value="${Order.UID}" required="required"><br/>
    产品编号：<input type="text" name="PID" value="${Order.PID}" required="required"><br/>
    <input type="hidden" name="method" value="update"/>
    <input type="submit" value="提交修改"/>
</form>
</body>
</html>