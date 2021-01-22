package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(count("wel", 'e'));
    }

    public static int count(String str, char ch) {
        if (str.length() > 0) {
            if (str.charAt(0) == ch)
                return 1 + count(str.substring(1, str.length()), ch);
            else
                return count(str.substring(1, str.length()), ch);
        }
        else
            return 0;
    }
}
