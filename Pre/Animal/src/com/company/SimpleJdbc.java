package com.company;

import java.sql.SQLException;
import java.lang.*;
import java.sql.*;

public class SimpleJdbc {
    public static void main(String[] args)
        throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "2055017970fei");
            System.out.println("Database connected");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from Student");
            while(resultSet. next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) +
                '\t' + resultSet.getString(4) + '\t' + resultSet.getString(5));;
            }
            connection.close();
    }
}


