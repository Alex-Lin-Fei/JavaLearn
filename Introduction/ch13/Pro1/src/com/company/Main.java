package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        double side1, side2, side3;
        String color;
        boolean filled;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the triangle`s sides, color and filled: ");
        side1 = input.nextDouble();
        side2 = input.nextDouble();
        side3 = input.nextDouble();
        color = input.next();
        filled = input.nextBoolean();
        Triangle triangle = new Triangle(side1, side2, side3, color, filled);
        System.out.println(triangle.toString());

    }
}

