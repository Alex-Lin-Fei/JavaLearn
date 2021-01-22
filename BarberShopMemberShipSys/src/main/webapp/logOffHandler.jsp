<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/21
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="controller" class="com.example.Cut.Controller" scope="application"></jsp:useBean>

<html>
<head>
    <title>LogOffHandler</title>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/font-awesome.min.css">
</head>
<body>
<%
    String telephone = request.getParameter("telephone");
    String password = request.getParameter("password");
    int id = request.getParameter("identity").endsWith("member")? 1: 2;
    int status = controller.logOff(telephone, password, id);
    if (status == 1) {
%>
<script>
    alert("The number" + <%=telephone%>+ " is not registered");
    window.document.location.href = "logOffPage.jsp"
</script>
<%
} else if (status == 2) {
%>
<script>
    alert("Sorry, database error");
    window.document.location.href = "logOffPage.jsp"
</script>
<%
} else if (status == 3) { %>
<script>
    alert("Your password is wrong");
    window.document.location.href = "logOffPage.jsp"
</script>
<%
} else {
%>
<script>
    alert("You have canceled  member " + <%= telephone%> +" successfully");
    window.document.location.href = "logOffPage.jsp"
</script>
<%
    }
%>
</body>
</html>
