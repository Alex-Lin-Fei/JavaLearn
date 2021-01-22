<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/21
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="controller" class="com.example.Cut.Controller" scope="application"></jsp:useBean>
<html>
<head>
    <title>DepositHandler</title>
</head>
<body>
<%
    String telephone = request.getParameter("telephone");
    String password = request.getParameter("password");
    double amount = Double.parseDouble(request.getParameter("amount"));
    //status 0(充值成功); 1(未注册); 2(数据库错误); 3(密码错误)
    int status = controller.ConsumeOrDeposit(telephone, password, amount, true);

    if (status == 1) {
%>
<script>
    alert("not found");
    window.document.location.href = "depositPage.jsp"
</script>
<%
} else if (status == 2) {
%>
<script>
    alert("Sorry, database error");
    window.document.location.href = "depositPage.jsp"
</script>
<%
} else if (status == 3) { %>
<script>
    alert("Your password is wrong");
    window.document.location.href = "depositPage.jsp"
</script>
<%
} else {
%>
<script>
    alert("You have deposited " + <%= amount%> +" successfully");
    window.document.location.href = "depositPage.jsp"
</script>
<%
    }
%>
</body>
</html>