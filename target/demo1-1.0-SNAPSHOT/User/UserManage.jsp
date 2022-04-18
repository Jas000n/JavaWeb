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
    <title>用户管理界面</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<h1>用户管理</h1>
<table>
    <tr>
        <th>用户编号</th>
        <th>用户密码</th>
        <th>用户地址</th>
        <th>联系方式</th>
        <th>用户角色</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="User" >
        <tr>
            <td>${User.UID}</td>
            <td>${User.password}</td>
            <td>${User.address}</td>
            <td>${User.phonenumber}</td>
            <td>${User.actor}</td>
            <td>
                <a href="/User/UserManage?method=deleteByUID&UID=${User.UID}">删除</a>
                <a href="/User/UserManage?method=findByUID&UID=${User.UID}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <a href="/User/Useradd.jsp">新增</a>
    <span>&nbsp</span>
    <a href="/index.jsp">返回</a>
</table>
</body>
</html>
