package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the array:");
        int r = input.nextInt();
        int c = input.nextInt();
        double[][] array = new double[r][c];
        System.out.println("Enter the array:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                 array[i][j] = input.nextDouble();
            Location location = locationLargest(array);
            System.out.println("The location of the largest element is "
                    + location.maxValue + " at (" +location.row + ", " + location.column + ")");


    }
    public static Location locationLargest(double[][] a) {
        int r = 0;
        int c = 0;
        double max = -100000;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                if (a[i][j] > max) {
                    max = a[i][j];
                    r = i;
                    c = j;
                }
        return new Location(r, c, max);
    }
}
