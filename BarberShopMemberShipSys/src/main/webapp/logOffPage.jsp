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
    <title>LogOffPage</title>
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


<!--注销-->
<form action="logOffHandler.jsp" method="post">
    <div class="page">
        <div class="function">
            请选择注册身份：
            <select name="identity" size="1">
                <option value="member">会员</option>
                <option value="barber">理发师</option>
            </select>
        </div>

        <div class="function">
            请输入注册电话号：
            <input class="out-phoneNo" required="required" type="text" name="telephone">
        </div>

        <div class="function">
            请输入注册密码：
            <input class="out-phoneNo" required="required" type="text" name="password">
        </div>

        <input type="submit" id="logOut" />

        <section class="main">
            <div class="crumbs">
                <strong>当前位置：</strong><a href="">注销</a>
            </div>
        </section>
    </div>
</form>


</body>
</html>
