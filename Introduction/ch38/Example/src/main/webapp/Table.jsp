<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/14
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="DbBeanId" class="com.example.CurrentTime.DbBean" scope="application"></jsp:useBean>
<html>
<head>
    <title>Table</title>
</head>
<body>
<% String[] tables = DbBeanId.getTables();
    if (tables == null) {%>
No Tables
<% } else {%>
<form method="post" action="BrowseTable.jsp">
    Select a table
    <select name="tablename" size="1">
        <% for (int i = 0; i < tables.length; i++) { %>
        <option><%= tables[i]%>
        </option>
        <% }
         } %>
    </select>
    <input type="submit" name="submit" value="Brows Table Content">
    <input type="reset" name="reset" value="Reset">
</form>
</body>

</html>
