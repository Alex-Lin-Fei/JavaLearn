package com.example.FirstServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {
    public void init() {
        System.out.println("init called");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("doGet called");
    }

    public void destroy() {
        System.out.println("destroy called");
    }
}
