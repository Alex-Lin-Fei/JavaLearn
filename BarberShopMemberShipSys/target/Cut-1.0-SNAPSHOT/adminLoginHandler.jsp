<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/22
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="controller" class="com.example.Cut.Controller" scope="application"></jsp:useBean>

<html>
<head>
    <title>AdminLoginHandler</title>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/font-awesome.min.css">
</head>
<body>

<%
    String telephone = request.getParameter("telephone");
    String password = request.getParameter("password");
    int status = controller.adminLogin(telephone, password);
    if (status == 1) {
%>
<script>
    alert("Sorry, you are not administrator");
    window.document.location.href="index.jsp"
</script>
<% } else if (status == 2) { %>
<script>
    alert("Sorry, database error");
    window.document.location.href="index.jsp"
</script>
<% } else if (status == 3) {%>
<script>
    alert("your password is wrong");
    window.document.location.href="index.jsp"
</script>
<% } else {%>
<script>
    alert("Welcome");
    window.document.location.href="registerPage.jsp"
</script>
<% } %>

</body>
</html>
