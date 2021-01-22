<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/16
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pollId" class="com.example.Exercise.OpinionPoll" scope="application"></jsp:useBean>
<jsp:setProperty name="pollId" property="*"></jsp:setProperty>
<html>
<head>
    <title>Show Count</title>
</head>
<body>
<% int[][] counts = pollId.getCounts(); %>
<%= "done"%>
<% for (int i = 0; i < pollId.getQuestions().length; i++){
%>
<p><%= pollId.getQuestions()[i]%>  ( <%= counts[i][0]%> Yes)(<%= counts[i][1]%> No)</p>
<% } %>
</body>
</html>
