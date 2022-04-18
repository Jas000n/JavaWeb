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
    <title>竞标信息修改</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>竞标信息修改</h1>
<form action="/Bid/BidManage" method="post">
    竞标编号(唯一标识，只读不可修改）：<input type="text" name="BID" value="${Bid.BID}" readonly/><br/>
    竞标工厂：<input type="text" name="fname" value="${Bid.fname}" required="required"><br/>
    竞标订单：<input type="text" name="OID" value="${Bid.OID}" required="required"><br/>
    竞标状态：<input type="text" name="status" value="${Bid.status}" required="required"><br/>
    竞标出价：<input type="text" name="price" value="${Bid.price}" required="required"><br/>
    <input type="hidden" name="method" value="update"/>
    <input type="submit" value="提交修改"/>
</form>
</body>
</html>