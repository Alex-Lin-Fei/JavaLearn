<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/14
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.CurrentTime.TimeBean" %>
<jsp:useBean id="timeBeanId" class="com.example.CurrentTime.TimeBean" scope="application">

</jsp:useBean>
<jsp:setProperty name="timeBeanId" property="*"></jsp:setProperty>
<html>
<head>
    <title>Display Time</title>
</head>
<body>
<h3>Choose locale and time zone</h3>
Current Time is
<%= timeBeanId.currentTimeString(timeBeanId.getLocaleIndex(), timeBeanId.getTimeZoneIndex())%>
</body>
</html>
