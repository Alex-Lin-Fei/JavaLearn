package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Circle c1 = new Circle(2, "yellow", false);
        Circle c2 = new Circle(1, "red", true);
        Rectangle r1 = new Rectangle(2, 2, "black", false);
        Rectangle r2 = new Rectangle(3, 2, "white", false);
        System.out.println("The area and perimeter of circles are: " + c1.getArea() + c1.getPerimeter() +
                c2.getArea() + c2.getPerimeter());
        System.out.println("The biggest is " + Circle.max(c1, c2));
        System.out.println("The area and perimeter of rectangles are: " + r1.getArea() + r1.getPerimeter() +
                r2.getArea() + r2.getPerimeter());
        System.out.println("The biggest is " + Rectangle.max(r1, r2));

    }
}
