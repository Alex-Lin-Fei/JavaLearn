<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/14
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="timeBeanId" class="com.example.CurrentTime.TimeBean" scope="application">

</jsp:useBean>
<html>
<head>
    <title>Display Time Form</title>
</head>
<body>
<h3>Choose locale and time zone</h3>
<form method="post" action="DisplayTime.jsp">
    Locale <select size="1" name="localeIndex">
    <% for (int i = 0; i < timeBeanId.getAllLocale().length; i++) {%>
    <option value="<%=i%>">
        <%= timeBeanId.getAllLocale()[i]%>
    </option>
    <%}%>
</select>

    Time Zone <select size="1" name="timeZoneIndex">
    <% for (int i = 0; i < timeBeanId.getAllTimeZone().length; i++) {%>
    <option value="<%=i%>">
        <%=timeBeanId.getAllTimeZone()[i]%>
    </option>
    <%}%>
</select>
    <input type="submit" name="submit" value="Get Time"/>
    <input type="reset" name="reset" value="Reset" />
</form>

</body>
</html>
