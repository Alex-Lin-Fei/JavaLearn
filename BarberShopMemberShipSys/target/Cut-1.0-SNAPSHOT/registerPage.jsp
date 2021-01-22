<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/21
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MemberRegisterPage</title>
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


<!--注册-->
<form action="registerHandler.jsp" method="post">
    <div class="page">

        <div class="function">
            请选择注册身份：
            <select name="identity" size="1">
                <option value="member">会员</option>
                <option value="barber">理发师</option>
            </select>
        </div>

        <div class="function">
            请输入姓名：
            <input id="name" type="text" required="required" name="name">
        </div>

        <div class="function">
            请输入电话号：
            <input type="text" required="required" name="telephone">
        </div>

        <div class="function">
            请输入密码：
            <input type="text" required="required" name="password">
        </div>

        <div class="function">
            请确认密码 ：
            <input type="text" required="required" name="confirm">
        </div>

        <input type="submit" id = "register" />

        <section class="main">
            <div class="crumbs">
                <strong>当前位置：</strong><a href="">注册</a>
            </div>
        </section>
    </div>
</form>


</body>
</html>
