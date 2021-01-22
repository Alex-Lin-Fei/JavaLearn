package com.company;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a = 9;
        int b = 9;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + " " + b);
        Scanner input = new Scanner(System.in);
//        System.out.println("Enter list size: ");
//        int size = input.nextInt();
        int[] list = {10, 1, 5, 16, 61, 9, 11, 1};
        partition(list);
        for (int i: list)
            System.out.print(i + " ");

    }
    public static int partition(int[] list) {
        if (list.length == 0)
            return -1;
        int left = 0;
        int right = list.length - 1;
        int i = left;
        int j = right;

        while (i != j) {
            while (list[j] > list[left] && j > i)
                j--;

            while (list[i] <= list[left] && i < j)
                i++;

            int t = list[i];
            list[i] = list[j];
            list[j] = t;


        }
//        list[i] = list[i] + list[left];
//        list[left] = list[i] - list[left];
//        list[i] = list[i] - list[left];
        int t = list[i];
        list[i] = list[left];
        list[left] = t;

        int[] l = new int[i];
        for (int k = 0; k < l.length; k++) {
            l[k] = list[k];
        }
        int[] r = new int[list.length - i - 1];
        for (int k = 0; k < r.length; k++) {
            r[k] = list[k + i + 1];
        }

        partition(l);
        partition(r);
        for (int k = 0; k < l.length; k++) {
            list[k] = l[k];
        }
        for (int k = 0; k < r.length; k++) {
            list[k + i + 1] = r[k];
        }

        return i;
    }
}
