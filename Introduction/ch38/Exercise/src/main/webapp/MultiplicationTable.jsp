<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/15
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise37_02</title>
</head>
<body>
<table border="1">
    <% for (int row = 0; row < 10; row++) { %>
        <tr>
            <td><% if (row!= 0) { %> <%= row%> <% } %></td>

    <% for (int col = 1; col < 10; col++){ %>
    <td><%= col * Math.max(1, row)%></td>
    <% } %>
    </tr>
    <% } %>
</table>
</body>
</html>
