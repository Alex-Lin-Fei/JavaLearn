package com.company;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.SQLClientInfoException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     // write your code here
     //2.1
     Scanner input = new Scanner(System.in);
     System.out.print("Enter miles:");
     double mile = input.nextDouble();
     System.out.println(mile + " miles is " + mile * 1.6 + " kilometers");

     System.out.println("**************************************");

     //2/2
     System.out.println("Enter length of the sides and height of the Equilateral triangle:");
     double side = input.nextDouble();
     double area = Math.sqrt(3) / 4 * Math.pow(side, 2);
     System.out.println("The area is " + area);
     System.out.println("The volume of the Triangular prism is " + area * side);

     System.out.println("**************************************");

     //2.3
     System.out.print("Enter a value of meter:");
     double meter = input.nextDouble();
     System.out.println(meter + " meters is " + meter * 3.2786 + " feet");

     System.out.println("**************************************");

     //2/4
     System.out.print("Enter a number in square meters:");
     double square = input.nextDouble();
     System.out.println(square + " square meters is " + square * 0.3025 + " pings");

     System.out.println("**************************************");

     //2.5
     System.out.print("Enter the subtotal and a gratuity rate:");
     double subtotal = input.nextDouble();
     double rate = input.nextDouble();
     double gratuity = subtotal * rate / 100;
     subtotal += gratuity;
     System.out.println("The gratuity is $" + gratuity + " and total is $" + subtotal);

     System.out.println("**************************************");

     //2.6
     System.out.print("Enter a number between 0 and 1000:");
     int num = input.nextInt();
     int multi = 1;
     while (num > 0) {
      int t = num % 10;
      multi *= t;
      num /= 10;
     }
     System.out.println("The multiplication of all digits in " + num + " is " + multi);

     System.out.println("**************************************");

     //2.7
     System.out.print("Enter the number of minutes:");
     double min = input.nextDouble();
     double days = min / (24 * 60);
     double years = days / 365;
     days %= 365;
     System.out.println(min + " minutes is approximately " + years + " years " + "and " + days + " days");

     System.out.println("**************************************");

     //2.8
     long totalMilliseconds = System.currentTimeMillis();
     long totalSeconds = totalMilliseconds / 1000;
     long currentSeconds = totalSeconds % 60;
     long totalMinutes = totalSeconds / 60;
     long currentMinutes = totalMinutes % 60;
     long totalHours = totalMinutes / 60;
     long currentHours = totalHours % 24;

     System.out.print("Enter the time zone offset to GMT:");
     int offset = input.nextInt();
     currentHours = (currentHours + offset + 24) % 24;
     System.out.println("The current time is " + currentHours + ":" + currentMinutes + ":" + currentSeconds);

     System.out.println("**************************************");

     //2.9
     System.out.print("Enter v0, v1, and t:");
     float v0 = input.nextFloat();
     float v1 = input.nextFloat();
     float t = input.nextFloat();
     System.out.println("The average acceleration is " + (v1 - v0) / t);

     System.out.println("**************************************");

     //2.10
     System.out.print("Enter the amount of water in kilograms:");
     double kilogram = input.nextDouble();
     System.out.print("Enter the initial temperature:");
     double temp = input.nextDouble();
     System.out.print("Enter the final temperature:");
     double temp2 = input.nextDouble();
     System.out.println("The energy needed is " + kilogram * (temp2 - temp) * 4148);

     System.out.println("**************************************");

     //2.11
     System.out.print("Enter the number of years:");
     float year = input.nextInt();

     float birth = year * 365 * 24 * 3600 / 7;
     float death = year * 365 * 24 * 3600 / 13;
     float immi = year * 36 * 24 * 3600 / 45;

     float begin = 312_032_486;
     System.out.println("The population in " + year + " is " + (begin + immi + birth - death));

     System.out.println("**************************************");

     //2.12
     System.out.print("Enter speed and acceleration:");
     double v = input.nextDouble();
     double a = input.nextDouble();
     System.out.println("The minimum runway length for this airplane is " + Math.pow(v, 2) / 2 / a);

     System.out.println("**************************************");

     //2.13
     System.out.print("Enter the monthly saving amount:");
     double month_money = input.nextDouble();
     double interest_rate = 0.003125;
     double six_money = 100;
     int months = 6;
     while (months-- > 0) {
      six_money *= (1 + interest_rate);
      if (months > 0)
       six_money += 100;
     }
     System.out.println("After the six month, the account value is " + six_money);

     System.out.println("**************************************");
     //2.14
     System.out.print("Enter weight in pounds:");
     double weight = input.nextDouble();
     System.out.print("Enter height in inches");
     double height = input.nextDouble();
     weight *= 0.45359237;
     height *= 0.0254;
     System.out.println("BMI is " + (Math.pow(height, 2) / weight));

     System.out.println("**************************************");
     //2.15
     System.out.print("Enter x1 and y1:");
     double x1 = input.nextDouble();
     double y1 = input.nextDouble();
     System.out.print("Enter x2 and y2:");
     double x2 = input.nextDouble();
     double y2 = input.nextDouble();
     System.out.println("The distance of the two points is " + (Math.pow(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2), 0.5)));

     System.out.println("**************************************");
     //2.16
     System.out.print("Enter the length of the side:");
     double length = input.nextDouble();
     System.out.println("The area of the hexagon is " + (3 * Math.pow(3, 0.5) / 2 * Math.pow(length, 2)));

     System.out.println("**************************************");

     //2/17
     System.out.print("Enter the temperature in Fahreheit between -58F and 41F:");
     double tem = input.nextDouble();
     System.out.print("Enter the wind speed(>= 2) in miles per hour:");
     double v3 = input.nextDouble();
     double twc = 35.74 + 0.6215 * tem - 35.75 * Math.pow(v3, 0.16) + 0.4275 * tem * Math.pow(v3, 0.16);
     System.out.println("The wind chill index is " + twc);

     System.out.println("**************************************");
     //2.18

     //2/19
     System.out.print("Enter the coordinates of three points separated by spaces like x1 y1 x2 y2 x3 y3:");
     double a1 = input.nextDouble();
     double b1 = input.nextDouble();
     double a2 = input.nextDouble();
     double b2 = input.nextDouble();
     double a3 = input.nextDouble();
     double b3 = input.nextDouble();
     double side1 = Math.pow(Math.pow(a2 - a1, 2) + Math.pow(b2 - b1, 2), 0.5);
     double side2 = Math.pow(Math.pow(a3 - a2, 2) + Math.pow(b3 - b2, 2), 0.5);
     double side3 = Math.pow(Math.pow(a3 - a1, 2) + Math.pow(b3 - b1, 2), 0.5);
     double s = (side1 + side2 +  side3) / 2;
     double area1 = Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);

     System.out.println("The area of the triangle is " + area1);
     System.out.println("**************************************");

     //2.20
     System.out.println("Enter balance and interest rate (e.g., 3 for 3%):");
     double balance = input.nextDouble();
     double i_rate = input.nextDouble();
     System.out.println("The interest is " + (balance * i_rate / 1200));

     System.out.println("**************************************");
     //2.21
     System.out.print("Enter investment amount:");
     double investment = input.nextDouble();
     System.out.print("Enter annual interest rate in percentage:");
     double monthlyInterestRate = input.nextDouble();
     System.out.print("Enter number of years:");
     double future = input.nextDouble();
     System.out.println("Future value is $" + (investment * Math.pow(1 + monthlyInterestRate / 100, future)));

     System.out.println("**************************************");
     //2/22

     //2.23
     System.out.print("Enter the driving distance:");
     double distance = input.nextDouble();
     System.out.print("Enter miles per gallon:");
     double gallon = input.nextDouble();
     System.out.print("Enter price per gallon:");
     double price = input.nextDouble();
     double cost = distance / gallon * price;
     System.out.println("The cost of driving is $" + cost);
    }
}
