package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner=new Scanner(System.in);
        Geometricobject[] square=new Geometricobject[5];

        for(int i=0;i<5;i++){
            System.out.println("the number."+i+" Square:");
            System.out.println("please enter the width and height:");
            double width=scanner.nextDouble();
            double height=scanner.nextDouble();
            System.out.println("please enter the color:");
            String color=scanner.next();
            System.out.println("please enter the filled:");
            boolean filled=scanner.nextBoolean();
            square[i]=new Square(width,height);
            square[i].setColor(color);
            square[i].setFilled(filled);
        }

        for(int i=0;i<5;i++){
            System.out.println(square[i].toString());
            square[i].toString();
        }


        Octagon octagon=new Octagon(5,"red",true);
        System.out.println("the octagon`s side is:");
        System.out.println(octagon.getSide());
        System.out.println("the octagon`s perimeter is:");
        System.out.println(octagon.getPerimeter());
        System.out.println("the octagon`s area is:");
        System.out.println(octagon.getArea());
        Octagon octagon1=(Octagon)octagon.clone();
        System.out.println(octagon.compareTo(octagon1));

    }
}
