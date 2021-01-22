<%@ page import="java.nio.file.LinkPermission" %><%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/15
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.Exercise.Quiz.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="quiz" class="com.example.Exercise.Quiz" scope="application"></jsp:useBean>
<html>
<head>
    <title>Addition Quiz</title>
</head>
<body>
<form method="get" action="AdditionQuizAnswer.jsp">

    <% for (int i = 0; i < 10; i++) { %>
    <%= quiz.getQuestions()[i].getAddend1() %> + <%= quiz.getQuestions()[i].getAddend2() %> = <input type="text" name="answers" size="2"/>
    <br/>
    <% } %>
    <p><input type="submit" value="Submit" name="submit" /></p>
</form>

</body>
</html>
