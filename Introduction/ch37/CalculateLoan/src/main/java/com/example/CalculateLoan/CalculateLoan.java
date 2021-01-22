package com.example.CalculateLoan;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CalculateLoan", value = "/CalculateLoan")
public class CalculateLoan extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double amount = Double.parseDouble(request.getParameter("amount"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        int years = Integer.parseInt(request.getParameter("years"));

        double monthlyPayment = getMonthlyPayment(amount,rate,years);
        double totalPayment = monthlyPayment*years*12;

        out.println("<p>Loan Amount: "+amount+"</p>");
        out.println("<p>Annual Interest Rate: "+rate+"</p>");
        out.println("<p>Number of Years: "+years+"</p>");
        out.println("<p>Monthly Payment: "+monthlyPayment+"</p>");
        out.println("<p>Total Payment: "+totalPayment+"</p>");
        out.close();
    }

    private double getMonthlyPayment(double amount, double rate, int years) {
        double monthlyRate = rate / 1200;
        return amount * monthlyRate / (1 -
                (1 / Math.pow(1 + monthlyRate, years * 12)));
    }

    public void destroy() {
    }
}