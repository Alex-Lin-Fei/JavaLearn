package com.company;

import javafx.collections.ObservableList;

public class Octagon extends Geometricobject implements Comparable<Octagon>,Cloneable{
    private double side;

    public Octagon(){}

    public Octagon(double side,String color,boolean filled){
        super(color,filled);
        this.side=side;
    }

    public void setSide(double side){
        this.side=side;
    }

    public double getSide(){
        return side;
    }

    @Override
    public double getArea(){
        return (2+2*Math.sqrt(2))*Math.pow(side,2);
    }

    public double getPerimeter(){
        return 8*side;
    }

    public int compareTo(Octagon octagon){
        return Double.compare(getArea(), octagon.getArea());
    }

    public Object clone(){
        try{
            Octagon octagon=(Octagon)super.clone();
            return octagon;
        }catch (CloneNotSupportedException ex){
            return null;
        }
    }







}
