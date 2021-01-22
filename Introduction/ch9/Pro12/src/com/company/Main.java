package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first line (x1, y1)" +
                " and (x2, y2) : ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        System.out.println("Enter the second line (x1, y1)" +
                " and (x2, y2) : ");
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        double x4 = input.nextDouble();
        double y4 = input.nextDouble();

        double a = y2 - y1;
        double b = x1 - x2;
        double e = x1 * (y2 - y1) - y1 * (x2 - x1);

        double c = y4 - y3;
        double d = x3 - x4;
        double f = x3 * (y4 - y3) - y3 * (x4 - x3);

        LinearEquation l = new LinearEquation(a, b, c, d, e, f);
        System.out.println("The intersecting point is (" + l.getX() + ", " + l.getY() + ")");


    }
}
