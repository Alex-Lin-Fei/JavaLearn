package com.example.FactorialTable;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "FactorialTable", value = "/FactorialTable")
public class FactorialTable extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<table border=1>");
        out.println("<tr><th>Number</th><th>Factorial</th></tr>");
        int f = 1;
        for (int i = 0; i <= 10; i++) {
            if (i != 0)
                f *= i;
            out.println("<tr><th>" + i + "</th><th>" + f + "</th></tr>");
        }

        out.println("</table>");
        out.close();
    }

    public void destroy() {
    }
}