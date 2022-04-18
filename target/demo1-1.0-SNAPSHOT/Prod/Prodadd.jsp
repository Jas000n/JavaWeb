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
    <title>产品添加</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<form action="/Prod/ProdManage" method="post">

    设备类型：<input type="text" name="type" required="required"><br/>
    <input type="hidden" name="method" value="add"/>
    <input type="submit" value="提交新增"/>
</form>
</body>
</html>
