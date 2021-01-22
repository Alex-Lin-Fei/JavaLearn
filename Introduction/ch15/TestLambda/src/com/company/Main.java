package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.setAction1(()->{
            System.out.println("Action 1");
        });


    }

    public void setAction1(T1 t) {
        t.m1();
    }
    @FunctionalInterface
    interface T1{
        public void m1();
    }
}
