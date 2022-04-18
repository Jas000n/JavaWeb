<%@ page import="java.util.Date" %>
<%@ page import="entity.User" %>
<%@ page import="dao.UserDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="util.welcome" %><%--
  Created by IntelliJ IDEA.
  User: jas0n
  Date: 2021/7/18
  Time: 12:00 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工厂管理员</title>
    <script type="text/javascript" src="../js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<%

        String UID = request.getAttribute("UID").toString();
        User thisuser = null;
        try {
            thisuser = UserDao.findByUID(UID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        session.setAttribute("thisuser",thisuser);
        %>
<h1>你好,工厂管理员${thisuser.UID}号用户！</h1>
<h2 align="center">
    <%=
    welcome.getwelcome()
    %>
</h2>
<a href="/view/Rentadd.jsp">设备租赁</a>
<a href="/view/Bidadd.jsp">工厂竞标</a>
<a href="/Equi/EquiManage">设备管理</a>
<h3 align="center"><a href="/view/login">退出登陆</a></h3>
</body>
</html>
