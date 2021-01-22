package com.example.RegistrationWithHttpSession;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RegistrationWithHttpSession", value = "/RegistrationWithHttpSession")
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

        // Hello
        PrintWriter out = response.getWriter();


        String id = request.getParameter("Id");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String mi = request.getParameter("mi");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");

        if (lastName.length() ==0 || firstName.length() == 0)
            out.println("Last Name and First Name are required");
        else{
            Staff staff = new Staff();
            staff.setId(id);
            staff.setLastName(lastName);
            staff.setFirstName(firstName);
            staff.setMi(mi);
            staff.setTelephone(telephone);
            staff.setEmail(email);
            staff.setAddress(address);
            staff.setCity(city);
            staff.setState(state);

            HttpSession httpSession= request.getSession();

            httpSession.setAttribute("staff", staff);
            out.println("You entered the following data");
            out.println("<p>ID: " + id);
            out.println("<br>Last name: " + lastName);
            out.println("<br>First name: " + firstName);
            out.println("<br>MI: " + mi);
            out.println("<br>Telephone: " + telephone);
            out.println("<br>Email: " + email);
            out.println("<br>Address: " + address);
            out.println("<br>City: " + city);
            out.println("<br>State: " + state);

            out.println("<p><form method=\"post\" action="+
                    "http://localhost:8080/RegistrationWithHttpSession_war/RegistrationWithHttpSession");
            out.println("<p><input type=\"submit\" value=\"Confirm\">");
            out.println("</form>");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();

        HttpSession httpSession = request.getSession();

        Staff staff = (Staff)(httpSession.getAttribute("staff"));

        try{
            storeStaff(staff);
            out.println(staff.getFirstName() + " " +staff.getLastName()
            + " is now registered in the database");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

    private void storeStaff(Staff staff) throws SQLException {
        pstmt.setString(1,staff.getId());
        pstmt.setString(2,staff.getLastName());
        pstmt.setString(3,staff.getFirstName());
        pstmt.setString(4,staff.getMi());
        pstmt.setString(5,staff.getAddress());
        pstmt.setString(6,staff.getCity());
        pstmt.setString(7,staff.getState());
        pstmt.setString(8,staff.getTelephone());
        pstmt.setString(9,staff.getEmail());
        pstmt.executeUpdate();
    }


    public void destroy() {
    }
}