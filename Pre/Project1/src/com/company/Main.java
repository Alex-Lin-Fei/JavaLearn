package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        声明一个三角形对象
        Triangle triangle=new Triangle();
//        设置三角形的边，颜色和填充
        triangle.setSide1(1);
        triangle.setSide2(1.5);
        triangle.setSide3(1);
        triangle.setColor("yellow");
        triangle.setFilled(true);
//        展示三角形信息
//        side1的长度为
        System.out.println("the side1 is:");
        System.out.println(triangle.getSide1());
//         side2的长度为
        System.out.println("the side2 is:");
        System.out.println(triangle.getSide2());
//        side3的长度为
        System.out.println("the side3 is:");
        System.out.println(triangle.getSide3());
//        三角形周长为
        System.out.println("the perimeter of the triangle is :");
        System.out.println(triangle.getPerimeter());
//        三角形面积为
        System.out.println("the area of the triangle is:");
        System.out.println(triangle.getArea());

//        三角形颜色为
        System.out.println("the color of the triangle is:");
        System.out.println(triangle.getColor());
//        三角形填充情况
        System.out.println("is the triangle filled?");
        System.out.println(triangle.getIsFilled());

    }
}
