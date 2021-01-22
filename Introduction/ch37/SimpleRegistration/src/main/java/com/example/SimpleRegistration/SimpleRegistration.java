package com.example.SimpleRegistration;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/SimpleRegistration")
public class SimpleRegistration extends HttpServlet {
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String URL ="jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8";
    private String USER = "root";
    private String PASSWORD= "131125fei";

    private String insertStr="insert into Staff values(?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private PreparedStatement pstmt;

    public void init() throws ServletException {
        initializeJdbc();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

        try{
            storeStaff(id, lastName,firstName,mi,phone,email,address,city,state);
            out.println(firstName + " " +lastName + " is now registered in the database");
        } catch (SQLException ignored) {
            ignored.printStackTrace();
        }
        out.close();
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


    public void destroy() {
    }
}