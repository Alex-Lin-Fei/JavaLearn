<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/15
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChangeTelephone</title>
</head>
<body>
<%= request.getParameter("username")%>
<%= setTelephone(request.getParameter("username"), request.getParameter("oldphone"),request.getParameter("newphone"), request.getParameter("confirmphone"))%>
<%! public String setTelephone(String username, String oldPhone, String newPhone, String confirmPhone) {
    String URL = "jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8";
    String USER = "root";
    String PASSWORD = "131125fei";

    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        ResultSet rst = conn.createStatement().executeQuery("select firstName, lastName, telephone from Staff where id = " + username);
        if (rst.next()) {
            if (!rst.getString(3).equals(oldPhone)) {
                return "The oldPhone is error, old phone is " + rst.getString(3) +" but you enter " + oldPhone;
            }
            if (!confirmPhone.equals(newPhone))
                return "the confirm phone" + confirmPhone + " is not same as new telephone " + newPhone;
            else{
                conn.createStatement().executeUpdate("update staff set telephone = " + newPhone +" where id = " + username);
                return "Hello, " + rst.getString(1) +" " + rst.getString(2) + ", your telephone has been updated!";
            }
        }
    }catch (ClassNotFoundException | SQLException ignored){}
    return null;
}
%>
</body>
</html>
