package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        reverseDisply("12345");
    }

    public static void reverseDisply(String value) {
        System.out.println(value.charAt(value.length() - 1));
        if (value.length() > 1)
            reverseDisply(value.substring(0, value.length() - 1));
    }
}
