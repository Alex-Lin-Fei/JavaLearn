package com.company;

public class MyStringBuilder1 {
    private String stringChars;


    public MyStringBuilder1(String s) {
        stringChars = new String(s);
    }

    public MyStringBuilder1 append(MyStringBuilder1 s) {
        String str = new String(stringChars + s.stringChars);
        return new MyStringBuilder1(str);
    }

    public MyStringBuilder1 append(int i) {
        StringBuilder temp = new StringBuilder(stringChars);
        temp.append(i);
        String string = temp.toString();
        return new MyStringBuilder1(string);
    }

    public int length() {
        return stringChars.length();
    }

    public char chatAt(int index) {
        return stringChars.charAt(index);
    }

    public MyStringBuilder1 toLowerCase() {
        char[] str = new char[stringChars.length()];
        for (int i = 0; i < stringChars.length(); i++) {
            str[i] = Character.toLowerCase(stringChars.charAt(i));
        }
        return new MyStringBuilder1(new String(str));
    }

    public MyStringBuilder1 substring(int begin, int end) {
        char[] str = new char[end - begin];
        for (int i = 0; i < str.length; i++) {
            str[i] = stringChars.charAt(i + begin);
        }
        return new MyStringBuilder1(new String(str));
    }

    public String toString() {
        return stringChars;
    }

    public void showString() {
        System.out.println("The string is: " + stringChars);
    }
}
