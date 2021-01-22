package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("please input the number of ball:");
        int num = input.nextInt();
        System.out.println("input the number of slots");
        int slots = input.nextInt();
        input.close();

        System.out.println();
        int[] slot= new int[slots];

        for(int i=0;i<num;i++){
            int count = 0;
            for(int j=0;j<slots-1;j++){
                char pos = Direcction();
                if(pos == 'R')
                    count++;
            }
            System.out.println();
            System.out.println("the number "+(i+1)+" ball fall into "+(count+1));
            slot[count]++;
        }

        for(int i=0;i<slot.length;i++)
            System.out.println("the number "+(i+1)+" slot has "+slot[i]+" ball ");
    }

    public static char Direcction(){
        double num = Math.random();
        if(num<0.5)
            return 'L';
        else
            return 'R';
    }
}
