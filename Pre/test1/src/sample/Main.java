package sample;

import java.util.Scanner;

public class Main{
    public static  void main(String[] args) {
        long millisecond = System.currentTimeMillis();

        long totalsecond = millisecond / 1000;
        long currentsecond = totalsecond % 60;
        long totalmin = totalsecond / 60;
        long currentmin = totalmin % 60;
        long totalhour = totalmin /60;
        long currenthour = totalhour % 24;

        Scanner input = new Scanner(System.in);
        int offset = input.nextInt();
        System.out.print("Enter the time zone offset to GMT:");
        System.out.println();
        System.out.print("The current time is "+(currenthour+offset)+":"+currentmin+":"+currentsecond);


    }
}

