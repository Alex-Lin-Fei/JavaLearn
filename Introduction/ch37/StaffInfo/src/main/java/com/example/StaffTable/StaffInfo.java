package com.example.StaffTable;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StaffInfo", value = "/StaffInfo")
public class StaffInfo extends HttpServlet {
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String URL ="jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8";
    private String USER = "root";
    private String PASSWORD= "131125fei";

    private String insertStr="insert into Staff values(?, ?, ?, ?, ?, ?, ?, ?, ?);";


    private Connection conn;
    private PreparedStatement pstmt;
    public void init() {
initializeJdbc();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        if (request.getParameter("insert")!=null) {
            try {
                insert(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void view(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("Id");



    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        pstmt = conn.prepareStatement(insertStr);


        String id = request.getParameter("Id");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String mi = request.getParameter("mi");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");

        storeStaff(id, lastName, firstName, mi, telephone, email, address, city, state);
        out.println(firstName + " " + lastName + " is now registered in the database");
        out.close();
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {

    }

    private void clear() {

    }

    private void initializeJdbc() {
        try{
            Class.forName(DRIVER);
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected with cookie");
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