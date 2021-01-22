<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/16
  Time: 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="guessId" class="com.example.Exercise.Capitals" scope="application" ></jsp:useBean>
<html>
<head>
    <title>Questions</title>
</head>
<body>
<form method="get" action="GuessCapitals.jsp">
What is the capital of <%= guessId.getCountries()[guessId.getIdx()]%>? <input type="text" name="answer" />
<input type="submit" name="submit" value="Submit">
</form>
</body>
</html>
