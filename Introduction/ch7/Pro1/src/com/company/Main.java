package com.company;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        //7.1
        /*
        System.out.print("Enter the number of students:");
        int numOfStudent = input.nextInt();
        System.out.print("Enter " + numOfStudent + " scores:");

        int[] score = new int[numOfStudent];
        char[] grade = new char[numOfStudent];
        for (int i = 0; i < numOfStudent; i++)
            score[i] = input.nextInt();
        f(score, grade);
        for (int i = 0; i < numOfStudent; i++) {
            System.out.println("Students " + i + " score is " + score[i] + " and grade is " + grade[i]);
        }
*/
        //7.3
        int[] count = new int[51];
        for (int i = 0; i < 51; i++) {
            count[i] = 0;
        }
        System.out.println("Enter the integers between 1 and 50:");
        int number;
        while ((number = input.nextInt()) != 0) {
            count[number]++;
        }

        for (int i = 0; i < 51; i++) {
           if (count[i] != 0) {
               System.out.println(i + " occurs " + count[i] + ((count[i] == 1) ?" time" : " times"));
           }
        }

        //7.5









    }
    //7.1
    public static void f(int[] score, char[] grade) {
        int best = 0;
        for (int i = 0; i < score.length; i++)
            if (best < score[i])
                best = score[i];

        for (int i = 0; i < score.length; i++) {
            if (score[i] >= best - 15) {
                if (score[i] >= best - 5)
                    grade[i] = 'A';
                else if (score[i] >= best - 10)
                    grade[i] = 'B';
                else
                    grade[i] = 'C';
            }
            else if (score[i] >= best - 20)
                grade[i] = 'D';
            else
                grade[i] = 'F';
        }


    }

    //7.3
}
