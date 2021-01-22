package com.company;


public class Main {

    public static void main(String[] args) {
        // write your code here
        Time time = new Time();
        System.out.println("The time is " + time.getHour() + ":" +
        time.getMinute() + ":" + time.getSecond());
        Time time1 = new Time(555550000);
        System.out.println("The time is " + time1.getHour() + ":" +
                time1.getMinute() + ":" + time1.getSecond());
        Time time2 = new Time(5, 23, 55);
        System.out.println("The time is " + time2.getHour() + ":" +
                time2.getMinute() + ":" + time2.getSecond());




    }



}
