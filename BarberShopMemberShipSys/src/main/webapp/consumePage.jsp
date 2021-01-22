<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/21
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="controller" class="com.example.Cut.Controller" scope="application"></jsp:useBean>
<html>
<head>
    <title>ConsumePage</title>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/font-awesome.min.css">
</head>

<body>
<header class="header">
    <h1 class="logo"><a href="index.jsp">理发店会员管理</a></h1>
</header>

<nav class="menu">
    <ul>
        <li><a href="registerPage.jsp">Member Register</a></li>
        <li><a href="depositPage.jsp">Deposit</a></li>
        <li><a href="consumePage.jsp">Consumption</a></li>
        <li><a href="checkBillPage.jsp">Query</a></li>
        <li><a href="subscribePage.jsp">Subscription</a></li>
        <li><a href="viewSubInfoPage.jsp">View Subscription</a></li>
        <li><a href="logOffPage.jsp">Logout</a></li>
    </ul>
</nav>

<!--充值-->
<form action="consumeHandler.jsp" method="post">
    <div class="page">

        <div class="function">
            请输入会员电话号：
            <input type="text" required="required" name="telephone">
        </div>

        <div class="function">
            请输入会员密码：
            <input type="text" required="required" name="password">
        </div>

        <div class="function">
            请输入消费金额：
            <input type="text" required="required" name="amount">
        </div>

        <input type="submit" id = "register" />

        <section class="main">
            <div class="crumbs">
                <strong>当前位置：</strong><a href="">会员消费</a>
            </div>
        </section>
    </div>
</form>

</body>
</html>
