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
    <title>排产添加</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>中标订单排产</h1>
<form action="/Sche/ScheManage" method="post">
    订单编号：<input type="text" name="OID" required="required"><br/>
    设备编号：<input type="text" name="EID" required="required"><br/>
    生产效率：<input type="text" name="efficiency" required="required"><br/>
    <input type="hidden" name="method" value="add"/>
    <input type="submit" value="提交新增"/>
</form>
</body>
</html>
