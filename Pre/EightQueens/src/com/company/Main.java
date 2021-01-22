package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int arrSize = 8;
        int[] list = new int[arrSize];
        for(int i=0;i<arrSize;i++)
            list[i]= i;
        int count = 0;
        boolean error = true;
        while(error){
            count++;
            error = false;
            randomizeArray(list);

            for(int i=0;i<arrSize;i++) {
                for (int j = i + 1; j < arrSize; j++) {
                    if (j - i == Math.abs(list[j] - list[i])) {
                        error = true;
                        break;
                    }
                }
                if (error)
                    break;
            }
        }

        int i;
        System.out.println("I have tried "+count+" times,and eventually succeed.");
        for(i=0;i<arrSize-1;i++)
            System.out.print("("+i+","+list[i]+"),");
        System.out.println("("+i+","+list[i]+")");

    }

    public static void randomizeArray(int[] list){
        int arrSize = list.length;
        int ranIndex;

        for(int i=0;i<arrSize;i++){
            ranIndex = (int)(Math.random() * arrSize);
            if(ranIndex != i){
                int temp = list[i];
                list[i] = list[ranIndex];
                list[ranIndex]=temp;
            }
        }
    }
}
