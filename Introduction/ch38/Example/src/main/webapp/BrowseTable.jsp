<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/15
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="DbBeanId" class="com.example.CurrentTime.DbBean" scope="application"></jsp:useBean>
<html>
<head>
    <title>BrowseTable</title>
</head>
<body>
<% String tableName = request.getParameter("tablename");
    ResultSet rsCols = DbBeanId.getConn().getMetaData().getColumns(null,null,tableName,null);
%>
<table border="1">
    <tr>
        <% while (rsCols.next()) { %>
            <th><%= rsCols.getString("COLUMN_NAME")%></th>
       <% } %>
    </tr>
    <% Statement stmt = DbBeanId.getConn().createStatement();
    ResultSet rst = stmt.executeQuery("select * from " + tableName);
    int columnCount = rst.getMetaData().getColumnCount();
    while (rst.next()) {
        response.getWriter().println("<tr>");
        for (int i = 0; i < columnCount; i++) { %>
    <td><%= rst.getString(i+1) %></td>
    <%    }
    response.getWriter().println("</tr>");
    } %>
</table>
</body>
</html>
