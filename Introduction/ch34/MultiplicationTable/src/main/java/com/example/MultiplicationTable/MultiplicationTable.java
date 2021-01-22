package com.example.MultiplicationTable;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "MultiplicationTable", value = "/MultiplicationTable")
public class MultiplicationTable extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<table border=1>");
        out.print("<tr><th colspan=10>Multiplication Table</th></tr>");
        for (int i = 0; i < 10; i++) {
            out.print("<tr>");
            if (i == 0) {
                out.print("<td>  </td>");
                for (int j = 1; j < 10; j++)
                    out.print("<td>" + j + "</td>");
            }
            else {
                out.print("<td>" + i + "</td>");
                for (int j = 1; j < 10; j++)
                    out.print("<td>" + i * j + "</td>");
            }
            out.print("</tr>");
        }

        out.println("</table>");
    }

    public void destroy() {
    }
}