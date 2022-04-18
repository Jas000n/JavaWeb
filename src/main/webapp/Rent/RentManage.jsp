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
    <title>租赁管理界面</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>租赁管理</h1>
<table>
    <tr>
        <th>租赁编号</th>
        <th>工厂名称</th>
        <th>设备编号</th>
        <th>租赁到期日期</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="Rent" >
        <tr>
            <td>${Rent.RID}</td>
            <td>${Rent.fname}</td>
            <td>${Rent.EID}</td>
            <td>${Rent.expiretime}</td>
            <td>
                <a href="/Rent/RentManage?method=deleteByRID&RID=${Rent.RID}">删除</a>
                <a href="/Rent/RentManage?method=findByRID&RID=${Rent.RID}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <a href="/Rent/Rentadd.jsp">新增</a>
</table>
</body>
</html>
