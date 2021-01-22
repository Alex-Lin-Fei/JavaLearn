package com.example.OpinionPoll;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "OpinionPoll", value = "/OpinionPoll")
public class OpinionPoll extends HttpServlet {
    private String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8";
    private static String USER = "root";
    private static String PASSWORD = "131125fei";

    private String viewStr = "select * from Poll";
    private Statement stmt;


    public void init() {
        try {
            initializeJdbc();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        try {
            ResultSet rst = stmt.executeQuery(viewStr);
            while (rst.next()) {
                out.println("<form method=\"post\" action=\"http://localhost:8080/OpinionPoll_war/OpinionPoll\">");
                out.println("<p><label>" + rst.getString(1) + "</label></p>");
                out.println("<p><input type=\"radio\" name=\"answer\" value=\"yes\">Yes</p>");
                out.println("<p><input type=\"radio\" name=\"answer\">No</p>");
                out.println("<p>");
                out.println("<input type=\"submit\" name=\"submit\" value=\"Submit\">");
                out.println("<input type=\"submit\" name=\"submit\" value=\"Submit\">");
                out.println("</p>");
                out.println("</form>");
            }
        } catch (SQLException throwables) {
            out.println("xx");
            throwables.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            if (request.getParameter("answer").equals("yes")) {
                stmt.executeUpdate("update Poll set yesCount = yesCount+1");
            } else
                stmt.executeUpdate("update Poll set noCount = noCount+1");
            ResultSet rst = stmt.executeQuery(viewStr);
            if(rst.next()) {
                out.println("The current Yes count is " + rst.getString(2));
                out.println("The current No count is " + rst.getString(3));
            }
        } catch (SQLException ignored) {
        }
    }

    private void initializeJdbc() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        System.out.println("Driver loaded");
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        stmt = conn.createStatement();
    }

    public void destroy() {
    }
}