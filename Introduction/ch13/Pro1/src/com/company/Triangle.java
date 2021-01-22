package com.company;

public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;
    private double perimeter;
    private double area;


    Triangle(){

    }

    Triangle(double side1, double side2, double side3,
             String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        perimeter = side1 + side2 + side3;
        area = Math.sqrt(perimeter * (perimeter - side1) * (perimeter - side2) * (perimeter - side3));
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    public String toString() {
        return "Area: " + area + "\n" + "Perimeter: " + perimeter + "\n" +
                "Color And Filled: " + this.getColor() + " " + this.isFilled() + "\n";
    }
}
