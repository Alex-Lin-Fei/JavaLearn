<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/14
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="factorialBeanId" class="com.example.CurrentTime.FactorialBean" scope="page">
</jsp:useBean>
<jsp:setProperty name="factorialBeanId" property="number" param="numbr"/>
<html>
<head>
    <title>FactorialBean</title>
</head>
<body>
<h3>Computer Factorial Using a Bean</h3>
<form>
    Enter new value: <input name="number" /><br/> <br/>
    <input type="submit" name="Submit" value="Compute Factorial" />
    <input type="reset" value="Reset" /><br/><br/>
    Factorial of
    <jsp:getProperty name="factorialBeanId" property="number"/> is
    <%@ page import="java.text.*" %>
    <% NumberFormat format = NumberFormat.getNumberInstance();%>
    <%= format.format(factorialBeanId.getFactorial())%>
</form>
</body>
</html>
