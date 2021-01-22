package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Triangle t1 = new Triangle();
        Triangle t2 = new Triangle(3, 4, 5);
        t1.setColor("black");
        t1.setFilled(true);
        t2.setColor("yellow");
        t2.setFilled(false);
        System.out.println("The t1`s area and perimeter is :" +
                t1.getArea() + " " + t2.getPerimeter());
        System.out.println("The t2`s area and perimeter is: " +
                t2.getArea() + " " + t2.getPerimeter());
        System.out.println("Is t1 filled? " + t1.isFilled());
        System.out.println("Is t2 filled? " + t2.isFilled());
        System.out.println("The color of t1:" + t1.getColor());
        System.out.println("The color of t2:" + t2.getColor());
        System.out.println(t1.toString());
        System.out.println(t2.toString());
    }
}
