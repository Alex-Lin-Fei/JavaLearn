<%@ page import="java.util.Arrays" %>
<%@ page import="com.example.Cut.Record" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/21
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="controller" class="com.example.Cut.Controller" scope="application"></jsp:useBean>
<html>
<head>
    <meta charset="UTF-8">
    <title>CheckBillHandler</title>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/font-awesome.min.css">
</head>
<header class="header">
    <h1 class="logo"><a href="index.jsp"> CheckBillHandler </a></h1>
</header>
<body>
<%
    String telephone = request.getParameter("telephone");
    String password = request.getParameter("password");
    ArrayList<Record> records = controller.checkBill(telephone, password);
    %>

<table align="center" border="1">
    <tr>
        <th>时间</th>
        <th>金额</th>
    </tr>
    <% for (Record record : records) { %>
    <tr>
        <td><%= record.time%>
        </td>
        <td><%= record.amount%>
        </td>
    </tr>

    <% } %>
</table>

<form action="checkBillPage.jsp" method="post">
    <input type="submit" value="return" />
</form>
</body>
</html>