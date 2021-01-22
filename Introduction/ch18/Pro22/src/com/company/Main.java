package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(dec2Hex(1024));
    }

    public static String dec2Hex(int value) {
        String str = null;
        if (value % 16 < 10)
            str = String.valueOf(value % 16);
        else {
            switch (value % 16) {
                case 10: str = "A";break;
                case 11: str = "B";break;
                case 12: str = "C";break;
                case 13: str = "D";break;
                case 14: str = "E";break;
                default:break;
            }
        }
        if (value / 16 > 0)
            return dec2Hex(value / 16) + str;
        else return str;

    }
}
