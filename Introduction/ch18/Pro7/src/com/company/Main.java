package com.company;

import javafx.scene.Scene;

import java.util.Scanner;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();
        System.out.println("The fib number is " + fib(num));
        System.out.println("the count times are " + count);
    }

    public static long fib(long index) {
        count++;
        if (index == 0)
            return 0;
        else if (index == 1)
            return 1;
        else
            return fib(index - 1) + fib(index - 2);

    }
}
