package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Square square = new Square();
        Square square1 = new Square(3);
        System.out.println(square1.getArea());
        square.howToColor();
    }
}
