package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] list = {6, 5, 3, 6, 9, 1};
        System.out.println(maxList(list));
    }

    public static int maxList(int[] list) {
        return
                maxList(list, 0);
    }

    public static int maxList(int[] list, int st) {
        if (list.length == st + 1)
            return list[st];
        else
            return Math.max(list[st], maxList(list, st + 1));
    }
}
