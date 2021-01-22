package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String s1 = "I am a student";
        String s2 = new String("I am a student");
        System.out.println(s1.equals(s2));
        Scanner input = new Scanner(System.in);
        int[][] brackets = new int[4][5];
        double[] rates = new double[5];
        System.out.println("Enter the brackets: ");
        for (int i = 0; i < 4; i++) {
            brackets[i][0] = 0;
            for (int j = 1; j < 5; j++)
                brackets[i][j] = input.nextInt();
        }
        System.out.println("Enter the rates: ");
        for (int i = 0; i < 5; i++)
            rates[i] = input.nextDouble() / 100;


        for (int amount = 50000; amount <= 60000; amount += 1000) {
            for (int status = 0; status < 4; status++) {
                Tax tax = new Tax(status, brackets, rates, amount);
                System.out.printf("%8.2f\t\t", tax.getTax());
            }
            System.out.println();
        }
    }
}
