package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] grid = readASolution();

        System.out.println(isVailid(grid)? "valid solution":"invalid solution");
    }

    public static int[][] readASolution(){
        Scanner scanner = new Scanner(System.in);
        int[][] grid = new int[9][9];
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                grid[i][j]= scanner.nextInt();

            return grid;
    }

    public static boolean isVailid(int[][] grid) {
        for (int i = 0; i < 9; i++)
            if (!is1To9(grid[i]))
                return false;

        for (int i = 0; i < 9; i++) {
            int[] temp = new int[9];
            for(int j=0;j<9;j++){
                temp[j]=grid[i][j];
            }
            if(!is1To9(temp))
                return false;
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int k=0;
                int[] list = new int[9];
                for(int row = i*3;row<i*3+3;row++)
                    for(int column=j*3;column<j*3+3;j++)
                        list[k++]=grid[row][column];
                if(!is1To9(list))
                    return false;
            }
        }

        return true;
    }


    public static boolean is1To9(int[] list){
        int[] temp = new int[list.length];

        java.util.Arrays.sort(temp);

        for(int i=0;i<9;i++)
            if(temp[i]!=i+1)
                return false;
            return true;
    }
}
