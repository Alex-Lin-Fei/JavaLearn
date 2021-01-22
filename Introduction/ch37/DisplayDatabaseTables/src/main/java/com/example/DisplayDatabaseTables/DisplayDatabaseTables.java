package com.example.DisplayDatabaseTables;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "DisplayDatabaseTables", value = "/DisplayDatabaseTables")
public class DisplayDatabaseTables extends HttpServlet {
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String URL;
    private String USER;
    private String PASSWORD;
    private String TABLE;
//    private static String URL="jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8";
//    private static String USER = "root";
//    private static String PASSWORD="131125fei";
    private String query="select * from ";
    private PreparedStatement pstmt;
    private Connection conn;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

//        获取前端参数
        URL = request.getParameter("url");
        USER = request.getParameter("username");
        PASSWORD = request.getParameter("password");
        TABLE = request.getParameter("table");

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

//        连接数据库
        initializeJdbc();

//        展示
        ResultSet rset = null;
        try {
            rset = pstmt.executeQuery();
            ResultSetMetaData rsMetaData = rset.getMetaData();
            out.println("<table border=1>");
            out.print("<tr>");
            int cols = rsMetaData.getColumnCount();
            for (int i = 1; i <= cols; i++)
                out.print("<th>"+rsMetaData.getColumnName(i)+"</th>");
            out.println("</tr>");

            while (rset.next()) {
                out.print("<tr>");
                for (int i = 1; i <= cols; i++)
                    out.print("<td>" + rset.getString(i) + "</td>");
                out.print("</tr>");
            }

            out.println("</table>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initializeJdbc() {
        try{
            Class.forName(DRIVER);
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected");
            query += TABLE;
            pstmt = conn.prepareStatement(query);
        }catch (Exception ignored){}
    }

    public void destroy() {
    }
}