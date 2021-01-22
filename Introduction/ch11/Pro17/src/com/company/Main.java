package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int m;
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter an integer m:");
        m = input.nextInt();
        int tmp = m;
        for (int i = 2; i < Math.sqrt(tmp); i++) {
            if (m == 1)
                break;
            if (isPrime(i)) {
                while (m % i == 0) {
                    if (list.contains(i))
                        list.remove((Integer) i);
                    else
                        list.add(i);
                    m /= i;
                }
            }
        }


        int n = 1;
        for (int i : list) {
            System.out.println(i);
            n *= i;
        }
        System.out.println("The smallest number n for m * n to be a perfect square is " + n);
        System.out.println("m * n is " + tmp * n);




    }
    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
