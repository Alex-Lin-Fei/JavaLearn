package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(count("hello, world, i am a student.", 'o', 0));

    }

    public static int count(String str, char a, int high) {
        if (str.length() > high) {
            if (str.charAt(high) == a)
                return 1 + count(str, a, ++high);
            else
                return count(str, a, ++high);
        }
        else
            return 0;
    }
}
