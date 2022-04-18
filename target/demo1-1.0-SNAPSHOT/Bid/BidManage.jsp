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
    <title>竞标管理界面</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>竞标管理</h1>
<table class="formCenter">
    <tr>
        <th>竞标编号</th>
        <th>竞标工厂</th>
        <th>竞标订单</th>
        <th>竞标状态</th>
        <th>竞标出价</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="Bid" >
        <tr>
            <td>${Bid.BID}</td>
            <td>${Bid.fname}</td>
            <td>${Bid.OID}</td>
            <td>${Bid.status}</td>
            <td>${Bid.price}</td>
            <td>
                <a href="/Bid/BidManage?method=deleteByBID&BID=${Bid.BID}">删除</a>
                <a href="/Bid/BidManage?method=findByBID&BID=${Bid.BID}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <a href="/Bid/Bidadd.jsp">新增</a>
    <span>&nbsp</span>
    <a href="/index.jsp">返回</a>
</table>
</body>
</html>
