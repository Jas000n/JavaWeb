<%@ page import="util.welcome" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>超级管理员界面</title>
    <script type="text/javascript" src="/js/time.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/css.css" />

</head>
<body>
<h1>您好，超级管理员Jason!您可以管理云工厂的一切！</h1>
<h2 align="center">
<%=
        welcome.getwelcome()
%>
</h2>
<br/>

<a class="larger" href="/Equi/EquiManage">设备管理</a><br />
<a class="larger" href="/Prod/ProdManage">产品管理</a><br/>
<a class="larger" href="/User/UserManage">用户管理</a><br />
<a class="larger" href="/Fact/FactManage">工厂管理</a><br/>
<a class="larger" href="/Rent/RentManage">租赁管理</a><br/>
<a class="larger" href="/Order/OrderManage">订单管理</a><br/>
<a class="larger" href="/Bid/BidManage">竞标管理</a><br/>
<a class="larger" href="/Sche/ScheManage">排产管理</a><br/>
<h3 align="center"><a href="/view/login">退出登陆</a></h3>
</body>
</html>