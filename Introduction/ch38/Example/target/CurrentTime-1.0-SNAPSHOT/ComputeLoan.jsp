<%--
  Created by IntelliJ IDEA.
  User: 20550
  Date: 2021/1/14
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ComputeLoan</title>
</head>
<body>
<% double loanAmount = Double.parseDouble(
        request.getParameter("loanAmount"));
   double rate = Double.parseDouble(
           request.getParameter("annualInterestRate"));
   double years = Double.parseDouble(
           request.getParameter("numberOfYears"));
   double monthlyInterestRate = rate / 1200;
   double monthlyPayment = loanAmount * monthlyInterestRate /
           (1-1/Math.pow(1+monthlyInterestRate,years*12));
   double totalPayment = monthlyPayment *years*12;%>
Loan Amount: <%= loanAmount%><br/>
Annual Interest Rate: <%= rate%><br/>
Number of Years: <%= years%><br/>
<b>
    Monthly Payment: <%= monthlyPayment%><br/>
    Total Payment: <%= totalPayment%><br/>
</b>
</body>
</html>
