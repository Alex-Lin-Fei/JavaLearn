<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/14
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Factorial</title>
</head>
<body>
<% for (int i = 0; i <= 10; i++){ %>
Factorial of <%= i%> is
<%=computeFactorial(i)%><br/>
<% } %>
<%!
private long computeFactorial(int n) {
    if (n == 0) return 1;
    else
        return n * computeFactorial(n-1);
}
%>
</body>
</html>
