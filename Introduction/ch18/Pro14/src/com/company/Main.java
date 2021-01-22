package com.company;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(countUpper("G"));
    }

    public static int countUpper(String str) {
        if (str.length() > 0) {
            if (Character.isUpperCase(str.charAt(0)))
                return 1 + countUpper(str.substring(1, str.length()));
            else
                return countUpper(str.substring(1, str.length()));
        }
        else
            return 0;
    }
}
