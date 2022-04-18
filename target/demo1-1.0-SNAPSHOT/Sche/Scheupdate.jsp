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
  <title>排产信息修改</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>排产信息修改</h1>
<form action="/Sche/ScheManage" method="post">
  排产编号(唯一标识，只读不可修改）：<input type="text" name="SID" value="${Sche.SID}" readonly/><br/>
  订单编号：<input type="text" name="OID" value="${Sche.OID}" required="required"><br/>
  设备编号：<input type="text" name="EID" value="${Sche.EID}" required="required"><br/>
  生产效率：<input type="text" name="efficiency" value="${Sche.efficiency}" required="required"><br/>
  <input type="hidden" name="method" value="update"/>
  <input type="submit" value="提交修改"/>
</form>
</body>
</html>