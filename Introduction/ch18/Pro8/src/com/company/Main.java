package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        reverseDisplay(1);

    }

    public static void reverseDisplay(int value) {
        System.out.print(value%10);
        if (value / 10 > 0)
            reverseDisplay(value/10);

    }
}
