package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Date;

public class GeometricObject {
    private String color = "white";
    private boolean filled;
    private Date dateCreated = new Date();

    public GeometricObject() {
    }

    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public String toString() {
        return "created on" + this.dateCreated + "\ncolor:" + this.color + "and filled:" + this.filled;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        GeometricObject[] objs = new GeometricObject[]{new GeometricObject(), new GeometricObject("white", false), new GeometricObject("black", false), new Rectangle(), new Rectangle("red")};
    }
}

