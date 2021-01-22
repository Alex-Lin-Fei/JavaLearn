package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of balls to drop: ");
        int numberOfBalls = input.nextInt();
        System.out.println("Enter the number of slots in the bean machine: ");
        int numberOfBeans = input.nextInt();

        int count;
        double num;
        int[] slots = new int[numberOfBeans];
        char[] path = new char[numberOfBeans - 1];

        int max = 0;

        for (int i = 0; i < numberOfBalls; i++) {
            count = 0;
            for (int j = 0; j < numberOfBeans - 1; j++) {
                num = Math.random();
                if (num < 0.5)
                    path[j] = 'L';
                else {
                    path[j] = 'R';
                    count++;
                }
            }
            System.out.println(path);
            slots[count]++;
            if (max < slots[count])
                max = slots[count];
        }
        System.out.println(max);

        while (max > 0) {
            for (int i = 0; i < numberOfBeans; i++) {
                if (slots[i] == max) {
                    System.out.print('0');
                    slots[i]--;
                } else
                    System.out.print(' ');
            }
            System.out.println();
            max--;
        }

    }
}
