package com.company;

import org.omg.DynamicAny.NameDynAnyPairSeqHelper;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        int a = (int)(Math.random() * 10);
        int b = (int)(Math.random() * 10);
        ArrayList<Integer> answer = new ArrayList<>();
        while (true) {
            System.out.println("What is " + a + " + " + b + "?" );
            int ans = input.nextInt();
            if (ans == a + b) {
                System.out.println("You got it!");
                break;
            }

            else {
                if (answer.contains(ans))
                    System.out.println("You already entered " + ans);
                else
                    answer.add(ans);
                System.out.println("Wrong answer. Try again");
            }

        }

    }
}
