<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/21
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="controller" class="com.example.Cut.Controller" scope="application"></jsp:useBean>
<html>
<head>
    <title>ConsumeHandler</title>
</head>
<body>
<%
    String telephone = request.getParameter("telephone");
    String password = request.getParameter("password");
    double amount = Double.parseDouble(request.getParameter("amount"));
    int status = controller.ConsumeOrDeposit(telephone, password, amount, false);
//status 0(消费成功); 1(未注册); 2(数据库错误); 3(密码错误); 4(余额不足)
    if (status == 1) {
%>
<script>
    alert("not found");
    window.document.location.href="consumePage.jsp"
</script>
<%
}else if(status == 2){
%>
<script>
    alert("Sorry, database error");
    window.document.location.href="consumePage.jsp"
</script>
<%
} else if (status == 3){ %>
<script>
    alert("your password is wrong");
    window.document.location.href="consumePage.jsp"
</script>

<%
} else if (status == 4){ %>
<script>
    alert("your balance is not enough ");
    window.document.location.href="consumePage.jsp"
</script>

<% }  else{
%>
<script>
    alert("You have consumed "+<%= amount%> + " successfully");
    window.document.location.href="consumePage.jsp"
</script>
<%
    }
%>
</body>
</html>