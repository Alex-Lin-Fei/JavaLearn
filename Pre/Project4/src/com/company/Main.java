package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//实例化两个矩形
        Rectangle rec1=new Rectangle(4,40);
        Rectangle rec2=new Rectangle(3.5,35.9);
        rec1.setColor("red");
        rec2.setColor("red");

//输出第一个矩形的属性信息
        System.out.println("the width,height and color of the first rectangle are: ");
        System.out.println(rec1.getWidth()+" "+rec1.getHeight()+" "+rec1.getColor());
        System.out.println("the area and circumference of the first rectangle:");
        System.out.println(rec1.getArea()+" "+rec1.getPerimeter());

//输出第二个矩形的属性信息
        System.out.println("the width,height and color of the second rectangle are: ");
        System.out.println(rec2.getWidth()+" "+rec2.getHeight()+" "+rec2.getColor());
        System.out.println("the area and circumference of the second rectangle:");
        System.out.println(rec2.getArea()+" "+rec2.getPerimeter());

//实例化两个时间对象，分别表示当前时间和指定时间
        Time time1=new Time();
        Time time2=new Time(555550000);

//      输出时间对象的属性
        System.out.println("current time is:");
        System.out.println(time1.getHour()+":"+time1.getMinute()+":"+time1.getSecond());
        System.out.println("the elapse time is:");
        System.out.println(time2.getHour()+":"+time2.getMinute()+":"+time2.getSecond());
    }
}
