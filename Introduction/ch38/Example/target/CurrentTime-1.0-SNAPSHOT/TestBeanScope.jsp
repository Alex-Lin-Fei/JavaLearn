<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/14
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.example.CurrentTime.Count"%>
<jsp:useBean id="count" scope="request" class="com.example.CurrentTime.Count">

</jsp:useBean>
<html>
<head>
    <title>TestBeanScope</title>
</head>
<body>
<h3>Testing Bean Scope in JSP(Application)</h3>
<% count.increaseCount(); %>
You are visitor number <%= count.getCount()%> <br/>
From host: <%= request.getRemoteHost()%>
and session: <%= session.getId()%>
</body>
</html>
