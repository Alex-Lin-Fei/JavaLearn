<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/14
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="staffId" class="com.example.CurrentTime.Staff" scope="session"></jsp:useBean>
<jsp:useBean id="storeStaffId" class="com.example.CurrentTime.StoreStaff" scope="application"></jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    try {
        storeStaffId.storeStaff(staffId);
        response.getWriter().println(staffId.getFirstName() + " " + staffId.getLastName()
                +" is now registered in the database");
        response.getWriter().close();
    } catch (SQLException throwables) {
        response.getWriter().println("error");
    }

%>
</body>
</html>
