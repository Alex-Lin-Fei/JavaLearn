package com.company;

import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.sql.*;

public class Main {
    private static String DRIVER="com.mysql.jdbc.Driver";
    private static String URL="jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8";
    private static String USER = "root";
    private static String PASSWORD="131125fei";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// write your code here
        Class.forName(DRIVER);
        System.out.println("Driver loaded");

        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        System.out.println("Database connected");

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from Student");

        ResultSetMetaData rsMetaData = resultSet.getMetaData();

        for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
            System.out.println(rsMetaData.getColumnName(i)+" " + rsMetaData.getColumnTypeName(i));

        int cols = rsMetaData.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= cols; i++)
                System.out.print(resultSet.getString(i) + " ");
            System.out.println();
        }

    }
}
