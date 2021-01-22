package com.company;

public class Square extends Geometricobject implements Colorable {
    private double width;
    private double height;

    public Square(){}

    public Square(double width,double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected double getPerimeter() {
        return 2*(height+width);
    }

    protected double getArea(){
        return width*height;
    }

    public void howToColor(){
        System.out.println("the square`s color is "+this.getColor());
        System.out.println("the square`s filled is "+this.isFilled());
    }

    public String toString(){
        howToColor();
        return super.toString();
    }
}
