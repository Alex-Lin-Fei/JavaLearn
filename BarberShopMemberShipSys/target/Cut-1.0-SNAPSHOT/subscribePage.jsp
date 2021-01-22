<%@ page import="java.util.ArrayList" %><%--
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
    <title>SubscribePage</title>
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

<!--预约-->
<div class="page">
    <form action="subscribeHandler.jsp" method="post">
        <p><strong><font color="pink">项目选择</font></strong></p>
        <br/>
        <select style="width:100px" name="project">
            <% for (int i = 0; i < controller.projects.length; i++) { %>
            <option value=<%= controller.projects[i]%>><%= controller.projects[i]%>
            </option>
            <%
                }
            %>
        </select>
        <br/>
        <br/>
        <p><strong><font color="pink">理发师选择</font></strong></p>
        <br/>
        <select style="width:100px" name="barber">
            <%
                ArrayList<String[]> barbers = controller.getBarbers();
                for (int i = 0; i < barbers.size(); i++) { %>
            <option value= <%= barbers.get(i)[0]%>>
                <%= barbers.get(i)[0]%> <%= barbers.get(i)[1] %>
            </option>
            <% }
            %>
        </select>
        <br/>
        <br/>

        <p><strong><font color="pink">会员电话:</font></strong></p>
        <br/>
        <input type="text" required="required" name="telephone"/>
        <br/>
        <br/>

        <p><strong><font color="pink">会员密码:</font></strong></p>
        <br/>
        <input type="text" required="required" name="password"/>
        <br/>
        <br/>

        <p><strong><font color="pink">时间选择:</font></strong></p>
        <br/>
        <input type="datetime-local" value="2020-09-08T19:30" name="time"/>
        <br/>
        <br/>

        <%--提交预订--%>
        <input type="submit"/>
    </form>

    <section class="main">
        <div class="crumbs">
            <strong>当前位置：</strong><a href="">subscribe</a>
        </div>
    </section>
</div>
</form>


</body>
</html>
