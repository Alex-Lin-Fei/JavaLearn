package com.company;

import javafx.scene.Scene;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(dec2Bin(450));
    }
    public static String dec2Bin(int value) {
        String str = String.valueOf(value % 2);
        if (value / 2 > 0) {
            return dec2Bin(value/2) + str;
        }
        else return str;

    }
}
