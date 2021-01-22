package com.company;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
//       Scanner in=new Scanner(System.in);
//       System.out.println("enter the monthly saving amount:");
//       double amount=in.nextInt();
//
//       int cycle=6;
//       double rate=1.00417;
//       double A=0;
//       while(cycle--!=0){
//           A=(A+amount)*rate;
//       }
//
//       System.out.println(A);
        String a = "12";
        String b = "34";
        fun(a,b);
        System.out.println(a+b);

    }

    public static void fun(String x,String y){
        x.concat(y);
        y=x;
        System.out.println(x+y);
    }

}
