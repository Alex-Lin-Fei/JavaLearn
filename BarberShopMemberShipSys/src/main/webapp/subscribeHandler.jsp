<%@ page import="java.sql.Date" %><%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/21
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="controller" class="com.example.Cut.Controller" scope="application"></jsp:useBean>
<html>
<head>
    <title>SubscribeHandler</title>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/font-awesome.min.css">
</head>
<body>
<%
    String project = request.getParameter("project");
    String barberId = request.getParameter("barber");
    String telephone = request.getParameter("telephone");
    String password = request.getParameter("password");
    String time = request.getParameter("time");
    System.out.println(time);
    int status = controller.subscribe(telephone, password, barberId, project, time);
    if (status == 1) {
%>
<script>
    alert("The number is not registered ");
    window.document.location.href = "subscribePage.jsp"
</script>
<% } else if (status == 2) { %>
<script>
    alert("sorry, database error");
    window.document.location.href = "subscribePage.jsp"
</script>
<% } else if (status == 3) { %>
<script>
    alert("The password is wrong");
    window.document.location.href = "subscribePage.jsp"
</script>
<% } else {%>
<script>
    alert("subscribe successfully");
    window.document.location.href = "subscribePage.jsp"
</script>
<% } %>

</body>
</html>
