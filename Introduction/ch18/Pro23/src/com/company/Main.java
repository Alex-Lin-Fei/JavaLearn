package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(bin2Dec("10101101"));
        System.out.println(hex2Dec("AD"));
    }

    public static int bin2Dec(String binaryString) {
        int orin = 1;
        int idx = binaryString.length() - 1;
        int tot = 0;
        int temp = 2;

        while (idx >= 0) {
            tot += Integer.parseInt(String.valueOf(binaryString.charAt(idx))) * orin;
            orin *= temp;
            idx--;
        }
        return tot;
    }

    public static int hex2Dec(String hexString) {
        int orgin = 1;
        int idx = hexString.length() - 1;
        int tot = 0;
        int temp = 16;

        while (idx >= 0) {
            if (Character.isDigit(hexString.charAt(idx)))
                tot += Integer.parseInt(String.valueOf(hexString.charAt(idx))) * orgin;
            else
                tot += ((hexString.charAt(idx) - 'A') + 10) * orgin;
            orgin *= temp;
            idx--;
        }
        return tot;

    }
}
