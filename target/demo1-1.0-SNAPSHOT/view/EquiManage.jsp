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
    <title>设备管理界面</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>产能中心设备管理</h1>
<table>
    <tr>
        <th>设备编号</th>
        <th>运行状态</th>
        <th>租用状态</th>
        <th>设备描述</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="Equi" >
        <tr>
            <td>${Equi.EID}</td>
            <td>${Equi.runstatus}</td>
            <td>${Equi.rentstatus}</td>
            <td>${Equi.type}</td>
            <td>
                <a href="/Equi/EquiManage?method=deleteByEID&EID=${Equi.EID}">删除</a>
                <a href="/Equi/EquiManage?method=findByEID&EID=${Equi.EID}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <a href="/Equi/Equiadd.jsp">新增</a>
</table>
</body>
</html>
