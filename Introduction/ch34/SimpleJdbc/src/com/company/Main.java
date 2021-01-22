package com.company;

import java.beans.EventHandler;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// write your code here
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8", "root", "131125fei");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(
                "select firstName, mi, lastName from Student where lastName = 'Smith'"
        );

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) +'\t' +
                    resultSet.getString(2) + '\t' + resultSet.getString(3));
        }
        connection.close();
    }
}
