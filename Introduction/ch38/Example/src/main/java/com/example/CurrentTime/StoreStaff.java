package com.example.CurrentTime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreStaff {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL ="jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8";
    private final String USER = "root";
    private final String PASSWORD= "131125fei";
    private final String insertStr ="insert into Staff " +
            "values(?,?,?,?,?,?,?,?,?)";
    private PreparedStatement pstmt;


    public StoreStaff() {
        initJdbc();
    }

    private void initJdbc() {
        try{
            Class.forName(DRIVER);
            System.out.println("Driver loaded");
            Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Connection");
            pstmt = conn.prepareStatement(insertStr);
        }catch (Exception ex){}
    }

    public void storeStaff(Staff staff) throws SQLException {
        System.out.println("start");
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
        System.out.println("done");
    }
}
