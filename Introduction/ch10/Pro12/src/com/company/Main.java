package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Triangle2D t1 = new Triangle2D(0, 0, 3, 0, 0, 3);
        System.out.printf("The perimenter and area is %.2f and %.2f\n",
                t1.getArea(), t1.getPerimeter());
        System.out.println("Does t1 contain (1, 2): " + t1.contains(new MyPoint(1, 2)));
        System.out.println("Does t1 contain triangle: " + t1.contains(new Triangle2D(1, 1, 1, 1.5, 1.5, 1)));
        System.out.println("Does t1 overlap triangle: " + t1.overlaps(new Triangle2D(1, 1, 1, 1.5, 1.5, 1)));
    }
}
