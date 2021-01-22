package com.example.StoreCookies;

import java.awt.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//color: red radius 5.5 count: 2
@WebServlet(name = "StoreCookies", value = "/StoreCookies")
public class StoreCookies extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        Cookie cookieColor = new Cookie("color", "red");
        response.addCookie(cookieColor);
        cookieColor.setMaxAge(2*24*60*60);
        Cookie cookieRadius = new Cookie("radius", "5.5");
        response.addCookie(cookieRadius);
        cookieRadius.setMaxAge(2*24*3600);
        Cookie cookieCount = new Cookie("count", "2");
        response.addCookie(cookieCount);
        cookieCount.setMaxAge(2*24*60*60);
    }

    public void destroy() {
    }
}