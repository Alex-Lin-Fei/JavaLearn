package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Enter the date: ");
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();
        int year = input.nextInt();
        String[] months = {"January", "February", "March", "April", "May",
        "June", "July", "August", "September", "October", "November", "December"};
        System.out.println("\t\t" + months[month - 1] + ", " + year);
        System.out.println("-----------------------------");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        Calendar calendar = new GregorianCalendar(year, month - 1, 1);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        Calendar c = new GregorianCalendar(year, month, 1);
        int start = calendar.get(Calendar.DAY_OF_WEEK);
        int sum = c.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR);
        for (int i = 0; i < start; i++)
            System.out.printf("%3c ", ' ');

        for (int i = 1; i <= sum; i++) {
            System.out.printf("%3d ", i);
            if ((i + start) % 7 == 0)
                System.out.println();
        }


    }
}
