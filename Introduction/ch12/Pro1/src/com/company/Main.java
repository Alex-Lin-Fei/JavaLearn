package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        String[] strings = new String[3];
        System.out.println("Enter the equation:");
        strings[0] = input.next();
        strings[1] = input.next();
        strings[2] = input.next();

        try {
            Calculator.main(strings);
        }catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}
