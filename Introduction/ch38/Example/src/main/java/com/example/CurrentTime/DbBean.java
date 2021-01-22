package com.example.CurrentTime;

import java.sql.*;

public class DbBean {
    private Connection conn = null;
    private String url;
    private String username;
    private String password;
    private String driver="com.mysql.jdbc.Driver";

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String[] getTables() {
        System.out.println("start");
        String[] tables = null;
        try {
            DatabaseMetaData dbMD = conn.getMetaData();
            ResultSet rsTables = dbMD.getTables(null, null, null, new String[]{"TABLE"});
            int size = 0;
            while (rsTables.next())
                size++;
            rsTables = dbMD.getTables(null, null, null, new String[]{"TABLE"});
            tables = new String[size];
            int i = 0;
            while (rsTables.next()) {
                tables[i++] = rsTables.getString("TABLE_NAME");
                System.out.println(tables[i-1]);
            }
        } catch (SQLException ignored) {
        }
        return tables;
    }

    public void initJdbc() {
        try{
            Class.forName(driver);
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
