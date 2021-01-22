<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.Cut.Subscription" %><%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/22
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="controller" class="com.example.Cut.Controller" scope="application"></jsp:useBean>
<html>
<head>
    <meta charset="UTF-8">
    <title>ViewSubInfoHandler</title>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/font-awesome.min.css">
</head>
<header class="header">
    <h1 class="logo"><a href="index.jsp"> ViewSubInfoHandler </a></h1>
</header>

<body>

<%
    boolean isMember = request.getParameter("identity").equals("member");
    String telephone = request.getParameter("telephone");
    String password = request.getParameter("password");
    ArrayList<Subscription> subscriptions = controller.viewSubInfo(telephone, password, isMember);
    %>

<table border="1">
    <tr>
        <th>Time</th>
        <th>Telephone</th>
        <th>
            <% if (isMember){ %>
            Barber
            <% } else {%>
            Customer
            <% } %>
        </th>
        <th>Project</th>
    </tr>
    <% for (Subscription subscription: subscriptions) { %>
<tr>
    <td><%= subscription.time%></td>
    <td><%= subscription.telephone%></td>
    <td><%= subscription.name%></td>
    <td><%= subscription.project%></td>
</tr>
<% } %>
</table>

<form action="viewSubInfoPage.jsp" method="post">
    <input type="submit" value="return" />
</form>
</body>
</html>
