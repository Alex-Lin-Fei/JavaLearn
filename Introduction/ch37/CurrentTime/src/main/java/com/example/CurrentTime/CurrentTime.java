package com.example.CurrentTime;

import java.io.*;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class CurrentTime extends HttpServlet {
    private String message;

    public void init() {
        message = "CurrentTime";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
        out.println("<p>The current time is " + new Date() + "</p>");
        out.close();
    }

    public void destroy() {
    }
}