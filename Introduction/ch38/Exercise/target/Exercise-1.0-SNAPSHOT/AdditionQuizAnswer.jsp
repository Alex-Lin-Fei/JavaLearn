<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/16
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="quiz" class="com.example.Exercise.Quiz" scope="application"></jsp:useBean>
<jsp:setProperty name="quiz" property="*"></jsp:setProperty>
<html>
<head>
    <title>Addition Quiz Answer</title>
</head>
<body>
<% for (int i = 0; i < quiz.getQuestions().length; i++){ %>
    <%= quiz.getQuestions()[i].getAddend1() %> + <%= quiz.getQuestions()[i].getAddend2() %> =
<%= quiz.getAnswers()[i]%>  <%= (quiz.getAnswers()[i] == quiz.getQuestions()[i].getSum())? "Correct": "Incorrect" %>
<br/>
<% } %>
</body>
</html>
