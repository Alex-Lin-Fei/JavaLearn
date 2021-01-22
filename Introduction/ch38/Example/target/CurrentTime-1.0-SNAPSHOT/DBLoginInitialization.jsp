<%@ page import="java.sql.DatabaseMetaData" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/14
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="DbBeanId" class="com.example.CurrentTime.DbBean" scope="application"></jsp:useBean>
<jsp:setProperty name="DbBeanId" property="*"></jsp:setProperty>
<html>
<head>
    <title>DBLoginInitialization</title>
</head>
<body>
<%
    DbBeanId.initJdbc();
%>
<% if (DbBeanId.getConn() == null) {%>
Error: Login failed. Try again.
<% }
else{ %><jsp:forward page="Table.jsp" />
<% } %>
</body>
</html>
