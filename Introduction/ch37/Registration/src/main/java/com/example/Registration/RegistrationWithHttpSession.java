package com.example.Registration;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/Registration")
public class RegistrationWithHttpSession extends HttpServlet {
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String URL ="jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8";
    private String USER = "root";
    private String PASSWORD= "131125fei";

    private String insertStr="insert into Staff values(?, ?, ?, ?, ?, ?, ?, ?, ?);";


    private PreparedStatement pstmt;

    public void init() {
        initializeJdbc();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("Id");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String mi = request.getParameter("mi");
        String phone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");

        if (lastName.length() == 0 || firstName.length() == 0)
            out.println("Last Name and First Name are required");

        else {
            Cookie cookieID = new Cookie("Id", id);
            Cookie cookieLastName = new Cookie("lastName", lastName);
            response.addCookie(cookieLastName);
            Cookie cookieFirstName = new Cookie("firstName", firstName);
            response.addCookie(cookieFirstName);
            Cookie cookieMi = new Cookie("mi", mi);
            response.addCookie(cookieMi);
            Cookie cookiePhone = new Cookie("telephone", phone);
            response.addCookie(cookiePhone);
            Cookie cookieEmail = new Cookie("email", email);
            response.addCookie(cookieEmail);
            Cookie cookieAddress = new Cookie("address", address);
            response.addCookie(cookieAddress);
            Cookie cookieCity = new Cookie("city", city);
            response.addCookie(cookieCity);
            Cookie cookieState = new Cookie("state", state);
            response.addCookie(cookieState);

            out.println("You entered the following data");
            out.println("<p>ID: " + id);
            out.println("<br>Last name: " + lastName);
            out.println("<br>First name: " + firstName);
            out.println("<br>MI: " + mi);
            out.println("<br>Telephone: " + phone);
            out.println("<br>Email: " + email);
            out.println("<br>Address: " + address);
            out.println("<br>City: " + city);
            out.println("<br>State: " + state);

            out.println("<p><form method=\"post\" action="+
                    "http://localhost:8080/RegistrationWithCookie_war/RegistrationWithCookie");
            out.println("<p><input type=\"submit\" value=\"Confirm\">");
            out.println("</form>");
        }

        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try{
            String id = request.getParameter("Id");
            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            String mi = request.getParameter("mi");
            String phone = request.getParameter("telephone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            storeStaff(id, lastName,firstName,mi,phone,email,address,city,state);
            out.println(firstName +" " + lastName
                    +" is now registered in the database");
        }catch (Exception ignored){}
    }

    private void storeStaff(String id, String lastName, String firstName,String mi,
                            String telephone, String email, String address,
                            String city, String state) throws SQLException {
        pstmt.setString(1,id);
        pstmt.setString(2,lastName);
        pstmt.setString(3,firstName);
        pstmt.setString(4,mi);
        pstmt.setString(5,address);
        pstmt.setString(6,city);
        pstmt.setString(7,state);
        pstmt.setString(8,telephone);
        pstmt.setString(9,email);
        pstmt.executeUpdate();
    }

    private void initializeJdbc() {
        try{
            Class.forName(DRIVER);
            System.out.println("Driver loaded");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected");
            pstmt = conn.prepareStatement(insertStr);
        }catch (Exception ignored){}
    }

    public void destroy() {
    }
}