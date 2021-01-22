<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/14
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="staffId" class="com.example.CurrentTime.Staff" scope="session"></jsp:useBean>
<jsp:setProperty name="staffId" property="*"/>
<html>
<head>
    <title>Registration Using JSP</title>
</head>
<body>
<h1>Registration Using JSP</h1>
<% if (staffId.getFirstName() == null || staffId.getLastName() == null) {
}%>
<p>You entered the following data</p>
<p>ID: <%= staffId.getId()%></p>
<p>Last name: <%= staffId.getLastName()%></p>
<p>First name: <%= staffId.getFirstName()%></p>
<p>MI: <%= staffId.getMi()%></p>
<p>Telephone: <%= staffId.getTelephone()%></p>
<p>Email: <%= staffId.getEmail()%></p>
<p>Address: <%= staffId.getAddress()%></p>
<p>City: <%= staffId.getCity()%></p>
<p>State: <%= staffId.getState()%></p>
<form method="post" action="StoreStaff.jsp">
    <input type="submit" value="Confirm">
</form>
</body>
</html>
