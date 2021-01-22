package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Rectangle r1 = new Rectangle(4, 40);
        Rectangle r2 = new Rectangle(3.5, 35.9);
        System.out.printf("%15s %10s %10s %10s %10s\n",
                "Rectangle", "width", "height", "area", "perimeter");
        System.out.printf("%15s %10.1f %10.1f %10.1f %10.1f\n",
                "r1", r1.width, r1.height, r1.getArea(), r1.getPerimeter());

        System.out.printf("%15s %10.1f %10.1f %10.1f %10.1f",
                "r2", r2.width, r2.height, r2.getArea(), r2.getPerimeter());




    }
}

