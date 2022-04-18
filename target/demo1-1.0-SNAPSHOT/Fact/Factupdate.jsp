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
  <title>工厂信息修改</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<form action="/Fact/FactManage" method="post">
  工厂名称(唯一标识，只读不可修改）：<input type="text" name="fname" value="${Fact.fname}" readonly/><br/>
  工厂管理员ID：(注意需要系统中有该管理员)<input type="text" name="UID" value="${Fact.UID}" required="required"><br/>
  运行状态：<label><input type="radio" name="status" value="0">未在运行</label><label><input type="radio" name="status" value="1">已在运行</label><br/>
  <input type="hidden" name="method" value="update"/>
  <input type="submit" value="提交修改"/>
</form>
</body>
</html>