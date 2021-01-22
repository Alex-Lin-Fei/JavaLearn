package com.company;

//矩形类
public class Rectangle {
//    数据成员  宽 高  颜色
    private double width=1;
    private double height=1;
    private String color="white";

//    默认无参构造函数
    public Rectangle(){}

//    有参构造函数
    public Rectangle(double w,double h) {
        this.width = w;
        this.height = h;
    }


//访问矩形类数据成员的方法声明定义

    public double getWidth(){ return this.width;}
    public double getHeight() { return this.height;}
    public String getColor() { return this.color; }


//    设置矩形类数据成员数值的方法声明定义
    public void setWidth(double w) { this.width=w; }
    public void setHeight(double h) { this.height=h; }
    public void setColor(String str) { this.color=str; }

//    获取矩形对象面积和周长的方法
    public double getArea(){ return this.width*this.height; }
    public double getPerimeter() { return 2*(this.width+this.height); }


}
