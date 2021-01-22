package com.example.Exercise;

import java.sql.*;
import java.util.Arrays;
import java.util.ResourceBundle;

public class OpinionPoll {
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String URL="jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8";
    private String USER = "root";
    private  String PASSWORD="131125fei";

    private Connection conn;
    private Statement stmt;

    private String[] questions;
    private String[] answers;

    //    获取所有问题
    public OpinionPoll() {
        initJdbc();
        try {
            ResultSet rst = stmt.executeQuery("select question from Poll");
            int size = 0;
            while (rst.next())
                size++;
            questions = new String[size];
            rst = stmt.executeQuery("select question from Poll");
            size = 0;
            while (rst.next())
                questions[size++] = rst.getString(1);
            Arrays.sort(questions);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void initJdbc() {
        try {
            Class.forName(DRIVER);
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException ignored) {
        }
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    public String[] getQuestions() {
        return questions;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int[][] getCounts() {
        initJdbc();
        int[][] counts = new int[questions.length][2];
        try {
            for (int i = 0; i < questions.length; i++) {
                ResultSet rst = stmt.executeQuery("select * from Poll where question = " + "\"" +questions[i] + "\"");
                int yesCount = 0, noCount = 0;

                if (rst.next()) {
                    yesCount = rst.getInt(2);
                    noCount = rst.getInt(3);
                }

                if (answers[i].equals("yes")) {
                    yesCount++;
                    stmt.executeUpdate("update Poll set yesCount = " + yesCount + " where question = " + "\"" +questions[i] + "\"");
                } else if (answers[i].equals("no")) {
                    noCount++;
                    stmt.executeUpdate("update Poll set noCount = " + noCount + "where question = " + "\"" +questions[i] + "\"");
                }
                counts[i][0] = yesCount;
                counts[i][1] = noCount;
            }
        } catch (SQLException ignored) {
            ignored.printStackTrace();
        }
        return counts;
    }
}
