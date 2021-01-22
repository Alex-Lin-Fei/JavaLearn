<%@ page import="java.util.Scanner" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileNotFoundException" %><%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/15
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise38_05</title>
</head>
<body>
<%= findScores(request.getParameter("ssn"), request.getParameter("courseId")) %>

<%! private String findScores(String ssn, String courseId) {
    try {
        Scanner read = new Scanner(new File("D:\\algorithm\\JavaCode\\Introduction\\ch38\\Exercise\\src\\scores\\" + courseId.toLowerCase() + ".txt"));
        while (read.hasNext()) {
            String[] record = read.nextLine().split("#");
            if (record[1].equals(ssn)) {
                return record[0] + " " + record[2];
            }
        }
    }catch (FileNotFoundException ignored){}

    return null;
}
%>

</body>
</html>
