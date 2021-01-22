package com.company;

public abstract class Geometricobject {
    private String color;
    private boolean filled;
    private java.util.Date dateCreate;

    protected Geometricobject(){
        dateCreate=new java.util.Date();
    }

    protected Geometricobject(String color,boolean filled){
        this.color=color;
        this.filled=filled;
        dateCreate=new java.util.Date();
    }

    protected String getColor(){
        return color;
    }

    protected boolean isFilled(){
        return filled;
    }

    protected void setColor(String color){
        this.color=color;
    }

    protected void setFilled(boolean filled){
        this.filled=filled;
    }

    public String toString(){
        return "created on "+dateCreate+"\ncolor: "+color+"\nfilled: "+filled;
    }

    protected abstract double getPerimeter();
    protected abstract double getArea();
}
