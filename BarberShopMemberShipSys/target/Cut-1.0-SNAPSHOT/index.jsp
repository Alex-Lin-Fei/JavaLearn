<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/font-awesome.min.css">
</head>

<body>
<header class="header">
    <h1 class="logo"><a href="index.jsp">理发店会员管理</a></h1>
</header>



<!--管理员登录-->
<form action="adminLoginHandler.jsp" method="post">
    <div class="page">

        <div class="function">
            请输入管理员注册号码：
            <input id="name" type="text" required="required" name="telephone">
        </div>

        <div class="function">
            请输入管理员密码：
            <input type="text" required="required" name="password">
        </div>

        <input type="submit" id = "login" />

        <section class="main">
            <div class="crumbs">
                <strong>当前位置：</strong><a href="">管理员登录</a>
            </div>
        </section>
    </div>
</form>


</body>
</html>
