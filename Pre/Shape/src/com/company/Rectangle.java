package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Rectangle extends GeometricObject implements Colorable {
    private String color = "white";

    public Rectangle() {
        this.howToColor();
    }

    public Rectangle(String color) {
        this.color = color;
        this.howToColor();
    }

    public void howToColor() {
        System.out.println("color the rec with " + this.color);
    }
}
