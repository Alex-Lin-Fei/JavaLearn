package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str = "I am a student";
        MyStringBuilder1 string1 = new MyStringBuilder1(str);
        string1.showString();
        MyStringBuilder1 string2 = new MyStringBuilder1(" and also a teacher");
        string2.showString();
        string1 = string1.append(string2);
        string1.showString();
        System.out.println("The length: " + string1.length());
        string2 = string1.toLowerCase();
        string2.showString();
        System.out.println("The string1 append " + 1 + " is " + string1.append(1));
        string1.showString();
        string2 = string1.substring(3, 6);
        string2.showString();
    }
}
