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
    <title>竞标添加</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>订单竞标</h1>
<form action="/Bid/BidManage" method="post">

    竞标工厂：<input type="text" name="fname" required="required"><br/>
    竞标订单：<input type="text" name="OID" required="required"><br/>
    竞标出价：<input type="text" name="price" required="required"><br/>
    <input type="hidden" name="method" value="add"/>
    <input type="submit" value="提交新增"/>
</form>
</body>
</html>
