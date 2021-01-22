package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(sumDigits(100));
    }

    public static int sumDigits(long n) {
        if (n / 10 == 0)
            return (int)n;
        else
            return (int)(n % 10) + sumDigits(n / 10);
    }
}
