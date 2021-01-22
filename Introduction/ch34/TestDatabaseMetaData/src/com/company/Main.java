package com.company;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// write your code here
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getConnection(
                "\"jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8", "root", "131125fei");

        System.out.println("Database connected");

        DatabaseMetaData dbMetaData = connection.getMetaData();




    }
}
