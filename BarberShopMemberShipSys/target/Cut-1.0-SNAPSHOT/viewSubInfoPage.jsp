<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/21
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ViewSubInfoPage</title>
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

<%--查看预约信息 可以是会员查看自己预约的项目也可以是理发师查看自己的预约信息--%>
<form action="viewSubInfoHandler.jsp" method="post">
    <div class="page" align="center">

        <div class="function">
            请输入您的身份：
            <select name="identity">
                <option value="member">会员</option>
                <option value="barber">理发师</option>
            </select>
        </div>

        <div class="function">
            请输入您的注册号码：
            <input type="text" required="required" name="telephone" />
        </div>

        <div class="function">
            请输入您的密码：
            <input type="password" required="required" name="password"/>
        </div>

        <input type="submit" id = "register" />

        <section class="main">
            <div class="crumbs">
                <strong>当前位置：</strong><a href="">查询预约</a>
            </div>
        </section>

    </div>

</form>
</body>
</html>
