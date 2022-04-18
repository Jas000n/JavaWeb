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
    <title>设备信息修改</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<form action="/Equi/EquiManage" method="post">
    设备编号(唯一标识，只读不可修改）：<input type="text" name="EID" value="${Equi.EID}" readonly/><br/>
    租用状态：<label><input type="radio" name="rentstatus" value="0"/>未被租用</label><label><input type="radio" name="rentstatus" value="1">已被租用</label><br/>
    运行状态：<label><input type="radio" name="runstatus" value="0"/>未在运行</label><label><input type="radio" name="runstatus" value="1">已在运行</label><br/>
    设备描述：<input type="text" name="type" value="${Equi.type}" required="required"><br/>
    <input type="hidden" name="method" value="update"/>
    <input type="submit" value="提交修改"/>
</form>
</body>
</html>