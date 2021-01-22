package com.company;

public class Circle extends GeometricObject implements Comparable{
    private double radius;

    public Circle() {

    }

    public Circle(double radius,
                  String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }



    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return Math.PI * this.getDiameter();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Circle) {
            if (this.getArea() - ((Circle) o).getArea() > 0)
                return 1;
            else if (this.getArea() - ((Circle) o).getArea() < 0)
                return -1;
            else return 0;
        }
        return -2;
    }
}
