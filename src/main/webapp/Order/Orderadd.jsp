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

  <title>订单添加</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>下单界面</h1>

<form action="/Order/OrderManage" method="post">


    到期时间：<input type="text" name="duetime" required="required"><br/>
    采购数量：<input type="text" name="quantity" required="required"><br/>
    顾客编号：<input type="text" name="UID" required="required"><br/>
    产品编号：<input type="text" name="PID" required="required"><br/>
  <input type="hidden" name="method" value="add"/>
  <input type="submit" value="提交新增"/>
</form>
</body>
</html>
