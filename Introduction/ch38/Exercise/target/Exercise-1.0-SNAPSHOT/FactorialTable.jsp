<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/15
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise38_01</title>
</head>
<body>
<table border="1">
<tr><th>Number</th><th>Factorial</th></tr>
<% for (int i = 0; i <= 10; i++) { %>
    <tr><td><%= i%></td><td><%= computeFactorial(i)%></td></tr>
<% } %>
</table>

<%! private long computeFactorial(int n) {
    if (n == 0)
        return 1;
    else
        return n * computeFactorial(n-1);
} %>
</body>
</html>
