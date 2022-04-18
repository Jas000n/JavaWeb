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
  <title>产品管理界面</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>产品管理</h1>
<table>
  <tr>
    <th>产品ID</th>
    <th>产品描述</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${list}" var="Prod" >
    <tr>
      <td>${Prod.PID}</td>
      <td>${Prod.type}</td>
      <td>
        <a href="/Prod/ProdManage?method=deleteByPID&PID=${Prod.PID}">删除</a>
        <a href="/Prod/ProdManage?method=findByPID&PID=${Prod.PID}">修改</a>
      </td>
    </tr>
  </c:forEach>
  <a href="/Prod/Prodadd.jsp">新增</a>
  <span>&nbsp</span>
  <a href="/index.jsp">返回</a>
</table>
</body>
</html>
