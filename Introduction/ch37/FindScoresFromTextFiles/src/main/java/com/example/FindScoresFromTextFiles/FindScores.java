package com.example.FindScoresFromTextFiles;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "FindScores", value = "/FindScores")
public class FindScores extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        String ssn = request.getParameter("ssn");
        String courseId = request.getParameter("course");

        String filePrefix = "D:\\algorithm\\JavaCode\\Introduction\\ch37\\FindScoresFromTextFiles\\src\\scores\\";
        Scanner read = new Scanner(new File(filePrefix + courseId.toLowerCase() + ".txt"));
        while (read.hasNext()) {
            String[] lines = read.nextLine().split("#");

            if (lines[1].equals(ssn)) {
                out.print(lines[0] + " " + lines[2]);
                break;
            }
        }
        read.close();
        out.close();
    }

    public void destroy() {
    }
}