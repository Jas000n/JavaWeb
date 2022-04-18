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
  <title>排产管理界面</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>排产管理</h1>
<table>
  <tr>
    <th>排产编号</th>
    <th>订单编号</th>
    <th>设备编号</th>
    <th>生产效率</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${list}" var="Sche" >
    <tr>
      <td>${Sche.SID}</td>
      <td>${Sche.OID}</td>
      <td>${Sche.EID}</td>
      <td>${Sche.efficiency}</td>
      <td>
        <a href="/Sche/ScheManage?method=deleteBySID&SID=${Sche.SID}">删除</a>
        <a href="/Sche/ScheManage?method=findBySID&SID=${Sche.SID}">修改</a>
      </td>
    </tr>
  </c:forEach>
  <a href="/Sche/Scheadd.jsp">新增</a>
  <span>&nbsp</span>
  <a href="/index.jsp">返回</a>
</table>
</body>
</html>
