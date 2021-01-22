package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] words = {"write", "that", "program"};
        Scanner input = new Scanner(System.in);
        char ch;
        String temp;
        int count;
        boolean isEixt = true;

        while (isEixt) {
            count = 0;
            int num = (int)(Math.random() * words.length);
            String str = words[num];
            System.out.println(str);
            char[] ans = new char[str.length()];
//            Arrays.fill(ans, '*');
            for (int i = 0; i < ans.length; i++)
                ans[i] = '*';
            while (true) {
                System.out.println("(Guess) Enter a letter in word " + Arrays.toString(ans) + " >");
                temp = input.next();
                ch = temp.charAt(0);
                switch (mend(str, ans, ch)) {
                    case 1:break;
                    case 2:System.out.println(ch + " is already in the word");
                    break;
                    case 3:{
                        System.out.println(ch + " is not in the word");
                        count++;
                    }break;
                }
                if (new String(ans).equals(str)) {
                    System.out.println("The word is " + str + ". You missed " +
                            count  + ((count == 1) ? " time" : "times"));
                    break;
                }

            }
            System.out.println("Do you want to guess another word? Enter y or n>");
            temp = input.next();
            ch = temp.charAt(0);
            if (ch == 'n')
                isEixt = false;
        }
    }

    public static int mend(String str, char[] ans, char ch) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch && ans[i] == '*') {
                ans[i] = ch;
                res = 1;
            }
            else if (str.charAt(i) == ch && ans[i] == ch)
                res = 2;
        }
        if (res == 0)
            res = 3;
        return res;
    }

}
