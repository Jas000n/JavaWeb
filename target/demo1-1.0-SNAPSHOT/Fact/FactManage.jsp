<%@ page import="entity.Equi" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.EquiDao" %><%--
  Created by IntelliJ IDEA.
  User: jas0n
  Date: 2021/7/15
  Time: 4:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>工厂管理界面</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>工厂管理</h1>
<table>
    <tr>
        <th>工厂名称</th>
        <th>管理员ID</th>
        <th>运行状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="Fact" >
        <tr>
            <td>${Fact.fname}</td>
            <td>${Fact.UID}</td>
            <td>${Fact.status}</td>
            <td>
                <a href="/Fact/FactManage?method=deleteByfname&fname=${Fact.fname}">删除</a>
                <a href="/Fact/FactManage?method=findByfname&fname=${Fact.fname}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <a href="/Fact/Factadd.jsp">新增</a>
    <span>&nbsp</span>
    <a href="/index.jsp">返回</a>
</table>
</body>
</html>
