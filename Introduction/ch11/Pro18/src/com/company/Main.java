package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(toCharacterArray(str));

    }

    public static ArrayList<Character> toCharacterArray(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            list.add(s.charAt(i));
        return list;
    }
}
