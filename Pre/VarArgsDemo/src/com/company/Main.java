package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        printMax(34,1,2,7,56,8,9,40);
        printMax(new double[]{1,5,3,7});

        double[] num = new double[]{14,32,5,6,7,32,89,0,76,23};
        insertSort(num);
        for(double elem:num)
            System.out.print(elem+" ");
        System.out.println();

    }
    public static void printMax(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("no argument passed");
            return;
        }
        double result = numbers[0];

        for (int i = 0; i < numbers.length; i++)
            if (result < numbers[i])
                result = numbers[i];

        System.out.println("the max is " + result);

        //测试Arrays类
        double[] num = {6.0, 4.4, 1.9, 2.9, 3.4, 3.5};
        java.util.Arrays.sort(num);

        char[] chars = {'a', 'A', '4', 'F', 'D', 'P'};
        java.util.Arrays.sort(chars, 1, 3);

        int[] list = {2, 4, 7, 10, 11, 45, 50, 50, 60, 66, 69, 70, 79};
        System.out.println("1.Index is " +
                java.util.Arrays.binarySearch(list, 11));
        System.out.println("2.index is " +
                java.util.Arrays.binarySearch(list, 12));
        ;
        char[] chars1 = {'a', 'c', 'g', 'x', 'y', 'z'};
        System.out.println("3.index is " +
                java.util.Arrays.binarySearch(chars1, 'a'));
        System.out.println("4.index is " +
                java.util.Arrays.binarySearch(chars1, 't'));

        int[] list1 = {2,4,3,6};
        int[] list2 = {3,4,5,6};
        int[] list3 = {2,4,3,6};
        System.out.println(java.util.Arrays.equals(list1,list2));
        System.out.println(java.util.Arrays.equals(list1,list3));

        java.util.Arrays.fill(list1,3);;
        java.util.Arrays.fill(list2,1,3,8);
        for(int elem:list1)
            System.out.print(elem+" ");
        System.out.println();
        for(int elem:list2)
            System.out.print(elem+" ");
        System.out.println();

    }

    public static void insertSort(double[] list){
        for(int i=0;i<list.length;i++){
            double elem = list[i];

            int k;

            for(k=i-1;k>=0 && list[k]>elem;k--){
                list[k+1]=list[k];
            }

            list[k+1]=elem;
        }
    }
}
