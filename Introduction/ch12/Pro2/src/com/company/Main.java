package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] months = {"January", "February", "March", "April",
                "May", "June","July", "August", "September", "October",
                "November", "December"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter a number between 1 and 12: ");
            int num = input.nextInt();

            System.out.println(dom[num - 1] + " " + months[num - 1]);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }
}
