<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/15
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Email</title>
</head>
<body>
<%= getEmail(request.getParameter("id")) %>
<%! public String getEmail(String id) {
    String URL = "jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8";
    String USER = "root";
    String PASSWORD = "131125fei";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        ResultSet rst = conn.createStatement().executeQuery("select firstName, lastName, email from Staff where id = " + id);
        System.out.println("st");
        if (rst.next())
            return rst.getString(1) +" " + rst.getString(2) +" " + rst.getString(3);
    }catch (ClassNotFoundException | SQLException ignored){}
    return null;
}
%>
</body>
</html>
