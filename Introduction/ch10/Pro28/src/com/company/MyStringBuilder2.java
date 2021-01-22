package com.company;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.security.PublicKey;

public class MyStringBuilder2 {
    private String stringChar;


    public MyStringBuilder2() {
        stringChar = "";
    }

    public MyStringBuilder2(char[] chars) {
        stringChar = new String(chars);
    }

    public MyStringBuilder2(String s) {
        stringChar = new String(s);
    }

    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
        StringBuilder temp = new StringBuilder(stringChar);
        temp.insert(offset, s.stringChar);
        String newString = temp.toString();
        return new MyStringBuilder2(newString);
    }

    public MyStringBuilder2 reverse() {
        StringBuilder temp = new StringBuilder(stringChar);
        String newString = temp.reverse().toString();
        return new MyStringBuilder2(newString);
    }

    public MyStringBuilder2 substring(int begin) {
        char[] string = new char[stringChar.length() - begin];
        for (int i = 0; i < string.length; i++) {
            string[i] = stringChar.charAt(begin + i);
        }
        return new MyStringBuilder2(string);
    }

    public MyStringBuilder2 toUpperCase() {
        char[] string = new char[stringChar.length()];
        for (int i = 0; i < string.length; i++)
            string[i] = Character.toUpperCase(stringChar.charAt(i));
        return new MyStringBuilder2(string);
    }

    public void showString() {
        System.out.println("The string is " + stringChar);
    }
}
