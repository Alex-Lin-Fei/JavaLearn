<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/21
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="controller" class="com.example.Cut.Controller" scope="application"></jsp:useBean>
<html>
<head>
    <title>MemberRegisterHandler</title>
</head>
<body>
<%
    String identity = request.getParameter("identity");
    int id = identity.equals("member")? 1: 2;
    String name = request.getParameter("name");
    String telephone = request.getParameter("telephone");
    String password = request.getParameter("password");
    String confirm = request.getParameter("confirm");
    int status = controller.register(name, telephone, password, confirm, id);
//status 取值为0(注册成功) ;1(号码已经被注册);2(密码不一致)
//    System.out.println(status);
    if (status == 0) {
%>
<script>
    alert("Register successfully");
    window.document.location.href = "registerPage.jsp"
</script>
<%
} else if (status == 1) {
%>
<script>
    alert("Sorry, the number is already registered");
    window.document.location.href = "registerPage.jsp"
</script>
<%
} else if (status == 2) {
%>
<script>
    alert("Sorry, the database error");
    window.document.location.href = "registerPage.jsp"
</script>
<%
} else{%>
<script>
    alert("Your password is inconsistent");
    window.document.location.href = "registerPage.jsp"
</script>
<% } %>
</body>
</html>
