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
    <title>订单管理界面</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>订单管理</h1>
<table>
    <tr>
        <th>订单编号</th>
        <th>竞标状态</th>
        <th>到期时间</th>
        <th>下单数量</th>
        <th>顾客编号</th>
        <th>下单产品</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="Order" >
        <tr>
            <td>${Order.OID}</td>
            <td>${Order.status}</td>
            <td>${Order.duetime}</td>
            <td>${Order.quantity}</td>
            <td>${Order.UID}</td>
            <td>${Order.PID}</td>
            <td>
                <a href="/Order/OrderManage?method=deleteByOID&OID=${Order.OID}">删除</a>
                <a href="/Order/OrderManage?method=findByOID&OID=${Order.OID}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <a href="/Order/Orderadd.jsp">新增</a>
    <span>&nbsp</span>
    <a href="/index.jsp">返回</a>
</table>
</body>
</html>
