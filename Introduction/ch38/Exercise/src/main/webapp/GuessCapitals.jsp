<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/16
  Time: 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="guessId" class="com.example.Exercise.Capitals" scope="application" ></jsp:useBean>
<jsp:setProperty name="guessId" property="*"></jsp:setProperty>
<html>
<head>
    <title>Guess Capitals</title>
</head>
<body>
<form method="get" action="DisplayQuestion.jsp">
    <%= guessId.judge() %>
    <input type="submit" value="Next">
</form>
</body>
</html>
