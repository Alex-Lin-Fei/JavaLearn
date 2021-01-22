package com.company;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //3.1
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c:");
        double a1 = input.nextDouble();
        double b1 = input.nextDouble();
        double c1 = input.nextDouble();
        double delta = Math.pow(b1, 2) - 4 * a1 * c1;
        if (delta >= 0) {
            double r1 = (-1 * b1 + Math.pow(delta, 0.5)) / 2 / a1;
            if (delta > 0) {
               double r2 = c1 / a1 / r1;
               System.out.println("The equation has two roots " + r1 + " and " + r2);
            }
            else {
                System.out.println("The equation has one root " + r1);
            }
        }
        else {
            System.out.println("The equation has no real root");
        }

        //3.2
        int num1 = (int)(System.currentTimeMillis() % 10);
        int num2 = (int)(System.currentTimeMillis() / 10 % 10);
        int num3 = (int)(System.currentTimeMillis() / 100 % 10);

        System.out.print("What is " + num1 + " + " + num2 + " + " + num3 + "?");
        int answer = input.nextInt();
        System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + answer + " is " + (num1 + num2 + num3 == answer));

        //3/3
        System.out.print("Enter a, b, c, d, e, f:");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        if (a * d - b * c == 0) {
            System.out.println("The equation has no solution");
        }
        else {
            double x = (e * d - b * f) / (a * d - b * c);
            double y = (a * f - c * e) / (a * d - b * c);
            System.out.println("x is " + x + " and y is " + y);
        }

        //3/4
        switch((int)((Math.random() * 12))) {
            case 0:System.out.println("January");break;
            case 1:System.out.println("February");break;
            case 2:System.out.println("March");break;
            case 3:System.out.println("April");break;
            case 4:System.out.println("May");break;
            case 5:System.out.println("June");break;
            case 6:System.out.println("July");break;
            case 7:System.out.println("August");break;
            case 8:System.out.println("September");break;
            case 9:System.out.println("October");break;
            case 10:System.out.println("November");break;
            case 11:System.out.println("December");break;
            default:break;
        }

        //3.5
        System.out.print("Enter today`s day:");
        int day = input.nextInt();
        System.out.print("Enter the number of days elapsed since today:");
        int numOfDay = input.nextInt();
        System.out.println("Today is ");
        switch (day) {
            case 0:System.out.print("Sunday");break;
            case 1:System.out.print("Monday");break;
            case 2:System.out.print("Tuesday");break;
            case 3:System.out.print("Wednesday");break;
            case 4:System.out.print("Thursday");break;
            case 5:System.out.print("Friday");break;
            case 6:System.out.print("Saturday");break;
            default:break;
        }
        System.out.print(" and the future day is ");
        day += numOfDay;
        day %= 7;
        switch (day) {
            case 0:System.out.print("Sunday");break;
            case 1:System.out.print("Monday");break;
            case 2:System.out.print("Tuesday");break;
            case 3:System.out.print("Wednesday");break;
            case 4:System.out.print("Thursday");break;
            case 5:System.out.print("Friday");break;
            case 6:System.out.print("Saturday");break;
            default:break;
        }
        System.out.println();

        //3.8
        System.out.print("Enter three integers:");
        double x = input.nextDouble();
        double y = input.nextDouble();
        double z = input.nextDouble();
        if (y < z) {
            y = y + z;
            z = y - z;
            y = y - z;
        }

        if (x < y) {
            x = x + y;
            y = x - y;
            x = x - y;
        }

        if (y < z) {
            y = y + z;
            z = y - z;
            y = y - z;
        }

        System.out.println("After sorting:" + x + " " + y + " " + z);

        //3.9
        System.out.print("Enter the first 9 digits of an ISBN as integer:");
        int isbn = input.nextInt();
        int d1 = isbn / 100000000;
        int d2 = isbn / 10000000 % 10;
        int d3 = isbn / 1000000 % 10;
        int d4 = isbn / 100000 % 10;
        int d5 = isbn / 10000 % 10;
        int d6 = isbn / 1000 % 10;
        int d7 = isbn / 100 % 10;
        int d8 = isbn / 10 % 10;
        int d9 = isbn % 10;

        int checknum = (d1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 *8 + d9 * 9) %11;
        if (checknum == 10)
            System.out.println("The ISBN-10 number is " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + "X");
        else
            System.out.println("The ISBN-10 number is " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + checknum);

        //3.11
        System.out.print("Enter the date:");
        int year = input.nextInt();
        int month = input.nextInt();
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                System.out.print(29);
            else System.out.print(28);
        }
        else {
            if (month > 7)
                month -= 7;
            if (month % 2 > 0)
                System.out.print(31);
            else System.out.print(30);
        }

        System.out.println();

        //3.13
        System.out.print("(0-single filer, 1-married jointly or" +
                "qualifying widow(er), 2-married separately, 3-head of " +
                "household) Enter the filing status:");
        int status = input.nextInt();

        System.out.print("Enter the taxable income:");
        double income = input.nextDouble();

        double tax = 0;

        if (status == 0) {
            if (income <= 8350)
                tax = income * 0.10;
            else if (income <= 33950)
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            else if (income <= 82250)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
            else if (income <= 171550)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
            else if (income <= 372950)
                tax =  8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82550) * 0.28 + (income - 171550) * 0.33;
            else
                tax =  8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82550) * 0.28 + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
        }
        else if (status == 1) {
            if (income <= 16700)
                tax = income * 0.10;
            else if (income <= 67900)
                tax = 16700 * 0.10 + (income - 16700) * 0.15;
            else if (income <= 137050)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (income - 67900) * 0.25;
            else if (income <= 208850)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (income - 137050) * 0.28;
            else if (income <= 372950)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (income - 208850) * 0.33;
            else
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (372950 - 208850) * 0.33 + (income - 372950) * 0.35;
        }
        else if (status == 2) {

        }
        else if(status == 3) {

        }
        else {

        }

        //3.17
        System.out.print("scissor(0), rock(1), paper(2):");
        int srp = input.nextInt();
        int cum = (int)(Math.random() * 3);
        System.out.print("The computer is ");
        switch (cum) {
            case 0:System.out.print("scissor. ");
            case 1:System.out.print("rock. ");
            case 2:System.out.print("paper. ");
            default:break;
        }
        System.out.print("You are ");
        switch (srp) {
            case 0:System.out.print("scissor");
            case 1:System.out.print("rock");
            case 2:System.out.print("paper");
            default:break;
        }
        if (srp == cum)
            System.out.print(" too. It is a draw\n");
        if ((srp == 0 && cum == 1) || (srp == 1 && cum == 2) || (srp == 2 && cum == 0))
            System.out.print(" Yon loss\n");
        else
            System.out.print(" Yon won\n");

        //3.19
        System.out.print("Enter three edges:");
        double e1 = input.nextDouble();
        double e2 = input.nextDouble();
        double e3 = input.nextDouble();

        if (e1 + e2 <= e3 || e1 + e3 <= e2 || e2 + e3 <= e1 )
            System.out.print("The data is invalid\n");
        else {
            System.out.println("The perimeter of the triangle is " + (e1 + e2 + e3));
        }

        //3.21
        System.out.print("Enter year:(e.g., 2012):");
        int Year = input.nextInt();
        System.out.print("Enter month:1-12:");
        int m = input.nextInt();
        if (m < 3) {
            Year--;
            m += 12;
        }
        System.out.print("Enter the day of the month:1-31:");
        int q = input.nextInt();
        int j = Year / 100;
        int k = Year % 100;
        int h = (q + 26 * (m + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
        switch (h) {
            case 0:System.out.print("Saturday");break;
            case 1:System.out.print("Sunday");break;
            case 2:System.out.print("Monday");break;
            case 3:System.out.print("Tuesday");break;
            case 4:System.out.print("Wednesday");break;
            case 5:System.out.print("Thursday");break;
            case 6:System.out.print("Friday");break;
            default:break;
        }

        //3.22
        System.out.print("Enter a point with two coordinates:");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.print("Point (" + x1 + "," + y1 + ") is ");
        if (Math.pow(x1 * x1 + y1 * y1, 0.5) > 10) {
            System.out.print("not ");
        }
        System.out.println("in the circle");

        //3.23
        System.out.print("Enter a point with two coordinates:");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        System.out.print("Point (" + x2 + "," + y2 + ") is ");
        if (Math.abs(x2 - 1) > 5 || Math.abs(y2 - 1) > 2.5) {
            System.out.print("not ");
        }
        System.out.println("in the rectangle");

        //3.24
        int rank = (int)(Math.random() * 13);
        int suit = (int)(Math.random() * 4);
        System.out.print("The card you picked is ");
        if (rank == 0)
            System.out.print("Ace ");
        else if (rank <= 10)
            System.out.print(rank + " ");
        else {
            switch (rank) {
                case 11:System.out.print("Jack ");break;
                case 12:System.out.print("Queen ");break;
                case 13:System.out.print("King ");break;
                default:break;
            }
        }
        System.out.print("of ");
        switch (suit){
            case 0:System.out.println("Clubs");break;
            case 1:System.out.println("Diamonds");break;
            case 2:System.out.println("Hearts");break;
            case 3:System.out.println("Spades");break;
            default:break;
        }

        //3.25
        System.out.print("Enter l1, m1, l2, m2, l3, m3, l4, m4:");
        double l1 = input.nextDouble();
        double m1 = input.nextDouble();
        double l2 = input.nextDouble();
        double m2 = input.nextDouble();
        double l3 = input.nextDouble();
        double m3 = input.nextDouble();
        double l4 = input.nextDouble();
        double m4 = input.nextDouble();

        double t = (m3 - m4) * (l1 - l2) - (m1 - m2) * (l3 - l4);
        double s1 = (m1 - m2) * l1 - (l1 - l2) * m1;
        double s2 = (m3 - m4) * l3 - (l3 - l4) * m3;
        double t1 = s2 * (l1 - l2) - s1 * (l3 - l4);
        double t2 = (m3 - m4) * s1 - (l1 - l2) * s2;
        if (t == 0)
            System.out.println("The two lines are parallel");
        else
            System.out.println("The intersecting point is at (" + (t1 / t) + " , " + (t2 / t));

        //3.26
        System.out.print("Enter a point`s x- and y- coordinates:");
        double x_ = input.nextDouble();
        double y_ = input.nextDouble();
        if (x_ >= 0 && y_ >= 0 && x_ + y_ <= 100)
            System.out.println("The point is in the triangle");
        else
            System.out.println("The point is not in the triangle");

        //3.28
        System.out.print("Enter r1`s center x-, y-coordinates, width, and height:");
        double r1_x = input.nextDouble();
        double r1_y = input.nextDouble();
        double r1_width = input.nextDouble();
        double r1_height = input.nextDouble();
        System.out.print("Enter r2`s center x-, y-coordinates, width, and height:");
        double r2_x = input.nextDouble();
        double r2_y = input.nextDouble();
        double r2_width = input.nextDouble();
        double r2_height = input.nextDouble();

        if (Math.abs(r1_x - r2_x) <= r1_width / 2 - r2_width / 2 && Math.abs(r2_y - r1_y) <= r1_height / 2 - r2_height / 2)
            System.out.println("r2 is inside r1");
        else if (Math.abs(r1_x - r2_x) > r1_width / 2 - r2_width / 2 && Math.abs(r1_x - r2_x) <= r1_width + r2_width &&
                Math.abs(r2_y - r1_y) > r1_height / 2 - r2_height / 2 && Math.abs(r2_y - r1_y) <= r1_height - r2_height)
            System.out.println("r2 overlaps r1");
        else
            System.out.println("r2 does not overlap r1");


        //3.29
        System.out.print("Enter circle1`s center x-, y-coordinates, and radius:");
        double c1_x = input.nextDouble();
        double c1_y = input.nextDouble();
        double c1_r = input.nextDouble();

        System.out.print("Enter circle2`s center x-, y-coordinates, and radius:");
        double c2_x = input.nextDouble();
        double c2_y = input.nextDouble();
        double c2_r = input.nextDouble();

        double dis = Math.pow(Math.pow(c1_x - c2_x, 2) + Math.pow(c1_y - c2_y, 2), 0.5);
        if (dis < c1_r + c2_r)
            System.out.println("circle2 overlaps circle1");
        else
            System.out.println("circle2 does not overlap circle1");

        //3.30
        System.out.print("Enter the time zone offset to GMT:");
        int gmt = input.nextInt();
        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;
        long currentSeconds = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinutes = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;

        currentHour = (currentHour + 24 +gmt) % 24;
        System.out.print("The current time is " + currentHour + ":" + currentMinutes + ":" + currentMinutes);
        if (currentHour <= 12)
            System.out.println("AM");
        else
            System.out.println("PM");

        //3.32
        System.out.print("Enter three points for p0, p1, and p2:");
        double x0 = input.nextDouble();
        double y0 = input.nextDouble();
        double x_1 = input.nextDouble();
        double y_1 = input.nextDouble();
        double x_2 = input.nextDouble();
        double y_2 = input.nextDouble();

        double res = (x_1 - x_2) * (y0 - y_2) - (x0 - x_2) * (y_1 - y_2);
        if (res < 0)
            System.out.print("p2 is on the right side of the line");
        else if (res > 0)
            System.out.print("p2 is on the left side of the line");
        else
            System.out.print("p2 is on the same line");


    }
}
