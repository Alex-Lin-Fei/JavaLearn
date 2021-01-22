<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/16
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pollId" class="com.example.Exercise.OpinionPoll" scope="application"></jsp:useBean>
<html>
<head>
    <title>Exercise38_13</title>
</head>
<body>
<form method="get" action="ShowCount.jsp">
    <% for (int i = 0; i < pollId.getQuestions().length; i++) { %>
    <p><%= pollId.getQuestions()[i]%> <label><input type="radio" name="answers" value="yes"/>Yes</label>
        <label><input type="radio" name="answers" value="no"/>No</label>
    </p>
    <% } %>
    <input type="submit" name="submit" value="Submit">
    <input type="reset" name="reset" value="Reset">
</form>

</body>
</html>
