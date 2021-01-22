package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        /*
        //5.1
        int score;
        System.out.print("Enter your scores:");
        while ((score = input.nextInt()) != -1) {
            if (score >= 60)
                System.out.println("You pass the exam");
            else
                System.out.println("You don`t pass the exam");
            System.out.print("Enter your scores:");
        }
        System.out.println("No numbers are entered except 0");

        //5.7
        final int NUM_OF_YEAR = 10;
        int countYear = 0;
        double tuition = 10000;
        double increases = 0.06;
        while (countYear < NUM_OF_YEAR) {
            tuition *= (1 + increases);
            countYear++;
        }
        System.out.println("The tuition is " + tuition);

        //5.9
        int lowest = 100;
        int second_lowest = 100;
        String lowestName = "";
        String secondName = "";
        System.out.print("Enter the number of the students:");
        int numOfStudent = input.nextInt();
        String name = "";
        int scores;
        while (numOfStudent-- > 0) {
            System.out.println("Enter the name of the student and scores:");
            name = input.next();
            scores = input.nextInt();
            if (scores < lowest) {
                second_lowest = lowest;
                lowest = scores;
                secondName = lowestName;
                lowestName = name;
            }
            else if (scores < second_lowest) {
                second_lowest = scores;
                secondName = name;
            }
        }

        System.out.println("The lowest scores and name are " + lowest + " " + lowestName);
        System.out.println("The second-lowest scores and name are " + second_lowest + secondName);

        //5.14
        System.out.print("Enter two integers :");
        int integer1 = input.nextInt();
        int integer2 = input.nextInt();
        int d = Math.min(integer1, integer2);
        while (d > 0) {
            if (integer1 % d == 0 && integer2 % d == 0)
                break;
            d--;
        }
        System.out.println("The gcd is " +d);

        //5.16
        System.out.print("Enter an integer:");
        int integer = input.nextInt();
        int a = 2;
        while (integer != 1) {
            if (integer % a == 0) {
                System.out.print(a + " ");
                integer /= a;
            }
            else
                a++;
        }
        System.out.println();

        //5.17
        System.out.print("Enter the number of lines:");
        int numLines = input.nextInt();
        for (int i = 7; i > 0; i--) {
            int j = i;
            for (j = i; j > 0; j--)
                System.out.print(j + " ");
            j += 2;
            if (i == 1)
                break;
            for (; j <= i; j++)
                System.out.print(j + " ");
            System.out.println();
        }
        System.out.println();


        //5.18
        int loop = 6;
        System.out.println("Pattern A:");
        for (int i = 1; i <= loop; i++) {
            for (int j = 0; j < i; j++)
                System.out.print("* ");
            System.out.println();
        }

        System.out.println("Pattern B:");
        for (int i = loop; i > 0; i--) {
            for (int j = i; j > 0; j--)
                System.out.print("* ");
            System.out.println();
        }

        System.out.println("Pattern C:");
        for (int i = loop - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--)
                System.out.print("  ");
            for (int k = 1; k <= loop - i; k++)
                System.out.print("* ");
            System.out.println();
        }

        System.out.println("Pattern D");
        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < i; j++)
                System.out.print("  ");
            for (int k = 0; k < loop - i; k++)
                System.out.print("* ");
            System.out.println();
        }

        //5.19
        for (int i = 0; i < 8; i++) {
            for (int l = 7 - i; l >= 0; l--)
                System.out.print("      ");
            for (int j = 0; j <= i; j++)
                System.out.printf("%6d", (int)Math.pow(3, j));
            for (int k = i - 1; k >= 0; k--)
                System.out.printf("%6d", (int)Math.pow(3, k));
            System.out.println();
        }

        //5.21
        System.out.print("Loan Amount:");
        double loanAmount = input.nextDouble();
        System.out.print("Number of Years:");
        int numOfYear = input.nextInt();

        System.out.println("Interest Rate\tMonthly Payment\tTotal Payment");
        double rate = 5;
        double payment;
        double total_payment;
        while (rate <= 10) {
            payment = (loanAmount * rate / 1200) / (1 - Math.pow(1 + rate / 1200, -1 * numOfYear * 12));
            total_payment = payment * 12 * numOfYear;
            System.out.printf("   %.3f%%   \t%.2f   \t%.2f\n", rate, payment, total_payment);

            rate += 0.25;
        }



        //5.22
        System.out.print("Loan Amount:");
        double balance = input.nextDouble();
        System.out.print("Number of Years:");
        int numberOfYears = input.nextInt();
        System.out.print("Annual Interest Rate:");
        double monthlyInterestRate = input.nextDouble() / 1200;
        double principal;
        double interest;

        double monthlyPayment = (balance * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -1 * numberOfYears * 12));
        System.out.println("Monthly Payment:" + monthlyPayment);
        System.out.println("Total Payment:" + monthlyPayment * numberOfYears * 12);

        System.out.println("Payment#\tInterest\tPrincipal\tBalance");
        for (int i = 1; i <= numberOfYears * 12; i++) {
            interest = balance * monthlyInterestRate;
            principal = monthlyPayment - interest;
            balance -= principal;

            System.out.println(i + "\t\t" + interest + "\t\t" + principal + "\t\t" + balance);
        }

        //5.27
        System.out.println("the leap years are as follows:");
        int tot = 0;
        for (int i = 2014; i <= 2114; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                System.out.print(i + " ");
                if ((++tot) % 10 == 0)
                    System.out.println();
            }
        }
        System.out.println();
        System.out.println("the number of leap years is " + tot);

        //5.28
        System.out.print("Enter the year and day:");
        int y = input.nextInt();
        int d = input.nextInt();

        for (int i = 1; i <= 12; i++) {
            switch (i) {
                case 1:System.out.print("January ");break;
                case 2:System.out.print("February ");break;
                case 3:System.out.print("March ");break;
                case 4:System.out.print("April ");break;
                case 5:System.out.print("May ");break;
                case 6:System.out.print("June ");break;
                case 7:System.out.print("July ");break;
                case 8:System.out.print("August ");break;
                case 9:System.out.print("September ");break;
                case 10:System.out.print("October ");break;
                case 11:System.out.print("November ");break;
                case 12:System.out.print("December ");break;
                default:break;
            }
            System.out.print( 1 + ", " + y + " is ");
            switch (d) {
                case 0:System.out.println("Sunday");break;
                case 1:System.out.println("Monday");break;
                case 2:System.out.println("Tuesday");break;
                case 3:System.out.println("Wednesday");break;
                case 4:System.out.println("Thursday");break;
                case 5:System.out.println("Friday");break;
                case 6:System.out.println("Saturday");break;
                default:break;
            }
            int j = i;
            if (j > 7)
                j -= 7;
            if (j % 2 == 1)
                d += 31;
            else if (j != 2)
                d += 30;
            else {
                if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
                    d += 29;
                else
                    d += 28;
            }
            d %= 7;
        }

*/

        //5.29
        System.out.print("Enter the year and day:");
        int year = input.nextInt();
        int day = input.nextInt();
        int days;

        for (int i = 1; i <= 12; i++) {
            System.out.print("\t\t\t\t");
            switch (i) {
                case 1:System.out.print("January ");break;
                case 2:System.out.print("February ");break;
                case 3:System.out.print("March ");break;
                case 4:System.out.print("April ");break;
                case 5:System.out.print("May ");break;
                case 6:System.out.print("June ");break;
                case 7:System.out.print("July ");break;
                case 8:System.out.print("August ");break;
                case 9:System.out.print("September ");break;
                case 10:System.out.print("October ");break;
                case 11:System.out.print("November ");break;
                case 12:System.out.print("December ");break;
                default:break;
            }
            System.out.println(year);
            System.out.println("------------------------------------------------");
            System.out.println("Sun\t\tMon\t\tTue\t\tWed\t\tThu\t\tFri\t\tSat");

            if ((i <= 7 && i % 2 == 1) || (i > 7 && (i - 7) % 2 == 1))
                days = 31;
            else if (i != 2)
                days = 30;
            else {
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                    days = 29;
                else
                    days = 28;
            }

            for (int j = 0; j < day; j++)
                System.out.print("   \t\t");
            for (int k = 1; k <= days; k++) {
                System.out.print(k + "\t\t");
                if ((k + day) % 7 == 0)
                    System.out.println();
            }
            day = (day + days) % 7;


            System.out.println();
        }





        //5.33
        int n = 1;
        while (n < 1000) {
            int sum = 1;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    sum += i + n / i;
            }
            if (sum == n)
                System.out.print(n + " ");

            n++;
        }
        
        //5.37
        int countP = 0;
        int countC = 0;
        int c, p;
        while (Math.abs(countC - countP) < 3) {
            System.out.print("scissor(0). rock(1), paper(2):");
            p = input.nextInt();
            c = (int)(Math.random() * 3);
            System.out.print("The computer is ");
            switch (c) {
                case 0:System.out.print("scissor. ");break;
                case 1:System.out.print("rock. ");break;
                case 2:System.out.print("paper. ");break;
                default:break;
            }
            System.out.print("You are ");
            switch (p) {
                case 0:System.out.print("scissor");break;
                case 1:System.out.print("rock");break;
                case 2:System.out.print("paper");break;
                default:break;
            }

            if (p == c) {
                System.out.println(" too. It is a draw");
            }
            else if (c - p == 1 || c - p == -2) {
                System.out.println(". You loss");
                countC++;
            }
            else {
                System.out.println(". You won");
                countP++;
            }
        }
        if (countC > countP)
            System.out.print("You loss.");
        else
            System.out.print("You won."); 
        
        
        //5.38
        System.out.print("Enter a decimal integer:");
        int decimal = input.nextInt();
        System.out.println("The octal value is:" + Integer.toOctalString(decimal));
        StringBuilder octal = new StringBuilder();
        while (decimal > 0) {
            octal.append(decimal % 8);
            decimal /= 8;
        }
        octal.reverse();
        System.out.println("The octal value is:" + octal);




        //5.41
        System.out.print("Enter numbers:");
        int num;
        int max = -1 * (1<<8);
        int count = 0;
        while ((num = input.nextInt()) != 0) {
            if (max == num)
                count++;
            else if (max > num) {
            }
            else {
                count = 1;
                max = num;
            }
        }

        System.out.print("Enter numbers:");
        System.out.println("The largest number is " + max);
        System.out.println("The occurance count of the largest number is " + count);


        



        //5.44
        System.out.print("Enter an integer:");
        int number = input.nextInt();
        String res = "";
        if (number < 0) {
            number += 256;
        }
        for (int i = 7; i >= 0; i--) {
            if (number >= (1 << i)) {
                number -= (1 << i);
                res += 1;
            } else
                res += 0;
        }

        
        System.out.println("The 8 bits are " + res);

        //5.45
        System.out.print("Enter 10 numbers:");
        double sum = 0;
        int TIMES = 10;
        double x;
        double deviation = 0;
        while (TIMES > 0) {
            x = input.nextDouble();
            sum += x;
            deviation += Math.pow(x, 2);
            TIMES--;
        }

        deviation = Math.pow((deviation - sum * sum / 10) / 9, 0.5);
        sum /= 10;

        System.out.println("The mean is " + sum);
        System.out.println("The standard deviation is " + deviation);

        //5.47
        System.out.print("Enter the first 12 digits of an ISBN-13 as a string:");
        String isbn = input.next();
        if (isbn.length() == 12) {
            int k = 0;
            int d13 = 0;
            while (k < 12) {
                d13 += isbn.charAt(k++) - '0';
                d13 += (isbn.charAt(k++) - '0') * 3;
            }
            d13 = 10 - d13 % 10;
            d13 = (d13 == 10) ? 0 : d13;
            System.out.println("The ISBN-13 number is " + isbn + d13);
        } else
            System.out.println(isbn + " is an invalid input");

        //5.49
        System.out.print("Enter a string:");
        String string = input.nextLine();
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isAlphabetic(string.charAt(i))) {
                char ch = Character.toUpperCase(string.charAt(i));
                if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
                    vowels++;
                else consonants++;
            }
        }
        System.out.println("The number of vowels is " + vowels);
        System.out.println("The number of consonants is " + consonants);


        //5.50
        System.out.print("Enter a string:");
        String s = input.nextLine();
        if (s.equals("Welcome to Java")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++)
                    System.out.print(j + "*" + i + "= " + i * j + "  ");
                System.out.println();
            }
        }

        //5.51
        System.out.print("Enter the first string:");
        String firstString = input.nextLine();
        System.out.print("Enter the second string:");
        String secondString = input.nextLine();

        int i = 0;
        while (firstString.charAt(i) == secondString.charAt(i)) {
            System.out.print(firstString.charAt(i));
            i++;
        }
        if (i == 0)
            System.out.println(firstString + " and " + secondString + " have no common prefix");


    }
}
