package com.company;

public class Triangle2D {
    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;
    private double perimeter;
    private double area;

    public Triangle2D() {
        p1.setX(0);
        p1.setY(0);
        p2.setX(1);
        p2.setY(1);
        p3.setX(2);
        p3.setY(5);
    }

    public Triangle2D(double x1, double y1,
                      double x2, double y2, double x3, double y3) {
        p1 = new MyPoint(x1, y1);
        p2 = new MyPoint(x2, y2);
        p3 = new MyPoint(x3, y3);

        double side1 = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
        double side2 = Math.sqrt(Math.pow(p1.getX() - p3.getX(), 2) + Math.pow(p1.getY() - p3.getY(), 2));
        double side3 = Math.sqrt(Math.pow(p3.getX() - p2.getX(), 2) + Math.pow(p3.getY() - p2.getY(), 2));
        perimeter = side1 + side2 + side3;
        double p = perimeter / 2;
        area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public boolean contains(MyPoint p) {
        double x1 = p2.getX() - p1.getX();
        double y1 = p2.getY() - p1.getY();
        double x2 = p3.getX() - p2.getX();
        double y2 = p3.getY() - p2.getY();
        double x3 = p1.getX() - p3.getX();
        double y3 = p1.getY() - p3.getY();

        double m1 = p.getX() - p1.getX();
        double n1 = p.getY() - p1.getY();
        double m2 = p.getX() - p2.getX();
        double n2 = p.getY() - p2.getY();
        double m3 = p.getX() - p3.getX();
        double n3 = p.getY() - p3.getY();

        return (x1 * n1 - y1 * m1 > 0 && x2 * n2 - y2 * m2 > 0 && x3 * n3 - y3 * m3 > 0)
                || (x1 * n1 - y1 * m1 < 0 && x2 * n2 - y2 * m2 < 0 && x3 * n3 - y3 * m3 < 0);
    }


    public boolean contains(Triangle2D t) {
        return contains(t.p1) && contains(t.p2) && contains(t.p3);

    }

    public boolean overlaps(Triangle2D t) {
        return (!contains(t.p1) || !contains(t.p2) || !contains(t.p3))
                && (contains(t.p1) || contains(t.p2) || contains(t.p3));
    }







}
