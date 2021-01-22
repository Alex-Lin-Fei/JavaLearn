package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StringBuilder list = new StringBuilder("abc");
        fun(list, 0);
    }

    public static void fun(StringBuilder list, int t){
        if (t == list.length()) {
            System.out.println(list);
        }
        else  {
            for (int i = t; i < list.length(); i++) {
                char temp = list.charAt(t);
                list.setCharAt(t, list.charAt(i));
                list.setCharAt(i,temp);
                fun(list,t + 1);
                temp = list.charAt(t);
                list.setCharAt(t, list.charAt(i));
                list.setCharAt(i,temp);
            }
        }


    }
}
