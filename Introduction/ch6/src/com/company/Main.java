package com.company;

import java.awt.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
/*
        //6.1
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%7d", getPentagonalNumber(i));
            if (i % 10 == 0)
                System.out.println();
        }
        //6.2
        System.out.print("Enter the number:");
        long number = input.nextLong();
        System.out.println("The sum of digits is " + sumDigits(number));

        //6.3
        System.out.print("Enter the palindrome integer:");
        int paliInteger = input.nextInt();
        if (isPalindrome(paliInteger))
            System.out.println(paliInteger + " is a palindrome integer");
        else
            System.out.println(paliInteger + " is not a palindrome integer");

        //6.4
        System.out.print("Enter a integer:");
        int num = input.nextInt();
        Reverse(num);

        //6.5
        System.out.print("Enter three numbers:");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();

        displaySortedNumbers(num1, num2, num3);

        //6.6
        //6.7
        System.out.print("The amount invested:");
        double invested = input.nextDouble();
        System.out.print("Annual interest rate:");
        double rate = input.nextDouble();

        System.out.println("Years\t\tFuture Value");
        for (int i = 1; i <= 30; i++) {
            System.out.println(i + "\t\t" + futureInvestmentValue(invested, rate / 1200, i));
        }

*/
        //6.18
        System.out.print("Enter the password:");
        String password = input.next();
        if (isValidPassword(password))
            System.out.println(password + " is a valid password");
        else
            System.out.println(password + " is an invalid password");










        //6.36
        System.out.print("Enter the number of sides:");
        int sides = input.nextInt();
        System.out.print("Enter the side:");
        double side = input.nextDouble();
        System.out.println("The area of the polygon is " + area(sides, side) );

        //6.39
        System.out.print("Enter three points for p0, p1, and p2:");
        double x0 = input.nextDouble();
        double y0 = input.nextDouble();
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            if (onTheLineSegment(x0, y0, x1, y1, x2, y2))
                System.out.println("(" + x2 + ", " + y2 + ")" +
                        " is on the line segment from (" + x0 + ", " + y0 + ") to ("
                         + x1 +", " + y1 + ")");
            else
                System.out.println("(" + x2 + ", " + y2 + ")" +
                        " is on the same line from (" + x0 + ", " + y0 + ") to ("
                        + x1 +", " + y1 + ")");
        }
        else if (leftOfTheLine(x0, y0, x1, y1, x2, y2))
            System.out.println("(" + x2 + ", " + y2 + ")" +
                    " is on the left side of the line from (" + x0 + ", " + y0 + ") to ("
                    + x1 +", " + y1 + ")");
        else
            System.out.println("(" + x2 + ", " + y2 + ")" +
                    " is on the right side of the line from (" + x0 + ", " + y0 + ") to ("
                    + x1 +", " + y1 + ")");
    }

    //6.1
    public static int getPentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }

    //6.2
    public static int sumDigits(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }


    //6.3
    public static int reverse(int number) {
        return Integer.reverse(number);
    }

    public static boolean isPalindrome(int number) {
        return number == reverse(number);
    }

    //6.4
    public static void Reverse(int number) {
        while (number > 0) {
            System.out.print(number % 10);
            number /= 10;
        }
        System.out.println();
    }

    //6.5
    public static void displaySortedNumbers(double num1, double num2, double num3) {
        double temp;

        if (num1 > num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        if (num1 > num3) {
            temp = num1;
            num1 = num3;
            num3 = temp;
        }

        if (num2 > num3) {
            temp = num2;
            num2 = num3;
            num3 = temp;
        }

        System.out.println("After sorting: " + num1 + " " + num2 + " " + num3);
    }

    //6.7
    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
    }

    //6.18
    public static boolean isValidPassword(String password) {
        if (password.length() < 10)
            return false;
        int sum = 0;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isDigit(password.charAt(i)) && !Character.isAlphabetic(password.charAt(i)))
                return false;
            if (Character.isAlphabetic(password.charAt(i)))
                sum++;
        }
        return sum >= 3;
    }

    //6.20
    public static int countLetters(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++)
            if (Character.isAlphabetic(s.charAt(i)))
                sum++;

        return sum;
    }

    //6.22
    public static double sqrt(long n) {
        double lastGuess = 1;
        double nextGuess = 0;
        while (Math.abs(lastGuess - nextGuess) > 0.0001) {
            nextGuess = (lastGuess + n / lastGuess) / 2;
            lastGuess = nextGuess;
        }

        return lastGuess;
    }

    //6.24
    public static void showCurrentTime() {
        
    }


    //6.36
    public static double area(int n, double side) {
        return n * Math.pow(side, 2) / 4 / Math.tan(Math.PI / n);
    }

    //6.39
    public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        return (x0 - x2) * (y1 - y0) - (x1 - x0) * (y0 - y2) > 0;
    }

    public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        return (y1 - y0) / (x1 - x0) == (y2 - y1) / (x2 - x1) ;
    }

    public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2) {
        return (y1 - y0) / (x1 - x0) == (y2 - y1) / (x2 - x1) && Math.min(x0, x1) <= x2 && x2 <= Math.max(x0, x1);
    }

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }

}
