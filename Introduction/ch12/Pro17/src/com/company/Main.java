package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        File file = new File("hangman.txt");
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(file);
        char ch;
        String temp;
        int count;
        boolean isEixt = true;
        ArrayList<String> words = new ArrayList<>();
        while (in.hasNext()) {
            temp = in.next();
            words.add(temp);
        }

        while (isEixt) {
            count = 0;
            int num = (int)(Math.random() * words.size());
            String str = words.get(num);
            System.out.println(str);
            char[] ans = new char[str.length()];
//            Arrays.fill(ans, '*');
            Arrays.fill(ans, '*');
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
