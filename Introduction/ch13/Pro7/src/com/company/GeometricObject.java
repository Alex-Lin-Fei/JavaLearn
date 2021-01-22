package com.company;

import java.util.Date;

public abstract class GeometricObject{
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    protected GeometricObject () {
        dateCreated = new Date();
    }

    protected GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public static GeometricObject max(GeometricObject g1, GeometricObject g2) {
        if (g1.getArea() > g2.getArea())
            return g1;
        else
            return g2;
    }

    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
