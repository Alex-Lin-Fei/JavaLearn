package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyStringBuilder2 string1 = new MyStringBuilder2("I am a student");
        string1.showString();
        MyStringBuilder2 string2 = string1.reverse();
        string2.showString();
        string1 = string2.toUpperCase();
        string1.showString();
        string2 = string1.substring(2);
        string2.showString();



    }
}
