package com.company;

import com.sun.deploy.net.proxy.WMozillaAutoProxyHandler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //4.1
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length from the center to a vertex:");
        double len = input.nextDouble();
        double s = len * Math.sin(Math.PI / 5) * 2;
        double area = 5 * Math.pow(s, 2) / 4 / Math.tan(Math.PI / 5);
        System.out.println("The area of the pentagon is " + area);

        //4.2
        System.out.print("Enter point 1 (latitude and longitude) in degrees:");
        double p1_la = input.nextDouble();
        double p1_lon = input.nextDouble();
        p1_la = Math.toRadians(p1_la);
        p1_lon = Math.toRadians(p1_lon);
        System.out.print("Enter point 2 (latitude and longitude) in degrees:");
        double p2_la = input.nextDouble();
        double p2_lon = input.nextDouble();
        p2_la = Math.toRadians(p2_la);
        p2_lon = Math.toRadians(p2_lon);

        double radius = 6371.01;
        double d = radius * Math.acos(Math.sin(p1_la) * Math.sin(p2_la) +Math.cos(p1_la) * Math.cos(p2_la) * Math.cos(p1_lon - p2_lon));

        System.out.println("The distance between the two points is " + d + " km");

        //4.5
        System.out.print("Enter the number of sides:");
        int sides = input.nextInt();
        System.out.print("Enter the side:");
        double side = input.nextDouble();
        double areaOf = sides * Math.pow(side, 2) / 4 / Math.tan(Math.PI / sides);
        System.out.println("The area of the polygon is " + areaOf);

        //4.6
        System.out.print("random poins:");
        double alpha1 = Math.random() * 2 * Math.PI;
        double p1_x = 40 * Math.cos(alpha1);
        double p1_y = 40 * Math.sin(alpha1);

        double alpha2 = Math.random() * 2 * Math.PI;
        double p2_x = 40 * Math.cos(alpha1);
        double p2_y = 40 * Math.sin(alpha1);

        double alpha3 = Math.random() * 2 * Math.PI;
        double p3_x = 40 * Math.cos(alpha1);
        double p3_y = 40 * Math.sin(alpha1);

        double side1 = Math.pow(Math.pow(p1_x - p2_x, 2) + Math.pow(p1_y - p2_y, 2), 0.5);
        double side2 = Math.pow(Math.pow(p1_x - p3_x, 2) + Math.pow(p1_y - p3_y, 2), 0.5);
        double side3 = Math.pow(Math.pow(p3_x - p2_x, 2) + Math.pow(p3_y - p2_y, 2), 0.5);

        double angle1 = Math.acos( (Math.pow(side1, 2) + Math.pow(side2, 2) - Math.pow(side3, 2)) / 2 / side1 / side2);
        double angle2 = Math.acos( (Math.pow(side1, 2) + Math.pow(side3, 2) - Math.pow(side3, 2)) / 2 / side1 / side3);
        double angle3 = Math.acos( (Math.pow(side1, 2) + Math.pow(side2, 3) - Math.pow(side1, 2)) / 2 / side3 / side2);

        System.out.println("The angles are " + angle1 + " " + angle2 + " " + angle3);

        //4.7
        System.out.print("Enter the radius of the bounding circle:");
        double r = input.nextDouble();
        System.out.println("The coordinates of five points on the pentagon are ");
        System.out.println("(" + r * Math.cos(Math.PI * (1.0 / 2)) + " , " + r * Math.sin(Math.PI * (1.0 / 2)) + ")");
        System.out.println("(" + r * Math.cos(Math.PI * (1.0 / 2 + 2.0 / 5)) + " , " + r * Math.sin(Math.PI * (1.0 / 2 + 2.0 / 5)) + ")");
        System.out.println("(" + r * Math.cos(Math.PI * (1.0 / 2 + 4.0 / 5)) + " , " + r * Math.sin(Math.PI * (1.0 / 2 + 4.0 / 5)) + ")");
        System.out.println("(" + r * Math.cos(Math.PI * (1.0 / 2 + 6.0 / 5)) + " , " + r * Math.sin(Math.PI * (1.0 / 2 + 6.0 / 5)) + ")");
        System.out.println("(" + r * Math.cos(Math.PI * (1.0 / 2 + 8.0 / 5)) + " , " + r * Math.sin(Math.PI * (1.0 / 2 + 8.0 / 5)) + ")");

        //4.8
        System.out.print("Enter a character:");
        String str = input.next();
        char ch = str.charAt(0);
        System.out.printf("The ASCII code for character %c is %d", ch, (int)ch);


        //4.11
        System.out.print("Enter binary digits (0000 to 1111):");
        String digits = input.next();
        int res = 0;
        if (digits.charAt(0) == '1')
            res += 8;
        if (digits.charAt(1) == '1')
            res += 4;
        if (digits.charAt(2) == '1')
            res += 2;
        if (digits.charAt(3) == '1')
            res += 1;
        System.out.println("The decimal value is " + res);

        //4.12
        System.out.print("Enter a hex digit:");
        String s1 = input.next();
        char c = s1.charAt(0);
        if (c < '0' || c > 'F')
            System.out.println(c + " is an invalid input");
        else {
            int val;
            if (c <= '9')
                val = c - '0';
            else
                val = c - 'A' + 10;
            System.out.print("The binary value is ");
            if (val >= 8) {
                System.out.print(1);
                val -= 8;
            }
            else
                System.out.print(0);
            if (val >= 4) {
                System.out.print(1);
                val -= 4;
            }
            else
                System.out.print(0);
            if (val >= 2) {
                System.out.print(1);
                val -= 2;
            }
            else
                System.out.print(0);
            if (val >= 1) {
                System.out.print(1);
                val -= 1;
            }
            else
                System.out.print(0);
        }

        //4.15
        System.out.print("Enter a letter:");
        String s2 = input.next();
        char c1 = s2.charAt(0);
        c1 = Character.toUpperCase(c1);
        if (!Character.isAlphabetic(c1))
            System.out.println(c1 + " is an invalid input");
        else {
            System.out.print("The corresponding number is ");
            if (c1 >= 'A' && c1 <= 'O')
                System.out.print((c1 - 'A') / 3 + 2);
            else if (c1 >= 'Q' && c1 <= 'S')
                System.out.print(7);
            else if (c1 >= 'W' && c1 <= 'Z')
                System.out.print(9);
            else
                System.out.print(8);
        }
        System.out.println();


        //4.17
        System.out.print("Enter a year:");
        int year = input.nextInt();
        System.out.print("Enter a month:");
        String month = input.next();
        if (!Character.isUpperCase(month.charAt(0)))
            System.out.print(month + " is not a correct month name");
        else {
            System.out.print(month + " " + year + " has ");
            switch (month){
                case "Jan":System.out.print(31);break;
                case "Feb":{
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                        System.out.print(29);
                    else
                        System.out.print(28);
                }
                break;
                case "Mar":System.out.print(31);break;
                case "Apr":System.out.print(30);break;
                case "May":System.out.print(31);break;
                case "Jun":System.out.print(30);break;
                case "Jul":System.out.print(31);break;
                case "Aug":System.out.print(31);break;
                case "Sept":System.out.print(30);break;
                case "Oct":System.out.print(31);break;
                case "Nov":System.out.print(30);break;
                case "Dec":System.out.print(31);break;
                default:System.out.print(month + " is not a correct month name");break;
            }
            System.out.println(" days");
        }


        //4.18
        System.out.print("Enter two characters:");
        String twoChar = input.next();
        if (twoChar.length() != 2 && twoChar.charAt(0) != 'A' && twoChar.charAt(0) != 'C' && twoChar.charAt(0) != 'i' &&
                (twoChar.charAt(1) < '1' || twoChar.charAt(1) > '4'))
            System.out.println("Invalid input");
        else {
            switch (twoChar.charAt(0)) {
                case 'I':System.out.print("Information Manaement");break;
                case 'C':System.out.print("Computer Science");break;
                case 'A':System.out.print("Accounting");break;
                default:break;
            }
            switch (twoChar.charAt(1)) {
                case '1':System.out.println(" freshman");break;
                case '2':System.out.println(" sophomore");break;
                case '3':System.out.println(" junior");break;
                case '4':System.out.println(" senior");break;
                default:break;
            }
        }

        //4.21
        System.out.print("Enter a SSN:");
        String ssn = input.next();
        if (ssn.length() == 11 && ssn.charAt(3) == '-' && ssn.charAt(6) == '-' &&
            Character.isDigit(ssn.charAt(0)) && Character.isDigit(ssn.charAt(1)) && Character.isDigit(ssn.charAt(2))
                 && Character.isDigit(ssn.charAt(4)) && Character.isDigit(ssn.charAt(5)) &&
                Character.isDigit(ssn.charAt(7)) && Character.isDigit(ssn.charAt(8)) && Character.isDigit(ssn.charAt(9)) &&
                Character.isDigit(ssn.charAt(10)))
            System.out.println(ssn + " is a valid social security number");
        else
            System.out.println(ssn + " is an invalid social security number");


        //4.22
        System.out.print("Enter string s1:");
        String str1 = input.next();
        System.out.print("Enter string s2:");
        String str2 = input.next();
        System.out.print(str2 + " is ");
        if (!str1.contains(str2))
            System.out.print("not ");
        System.out.println(" substring of " + str1);


        // 4.23
        System.out.print("Enter emplyee`s name:");
        String name = input.next();
        System.out.print("Enter number of hours worked in a week:");
        double workHours = input.nextDouble();
        System.out.print("Enter hourly pay rate:");
        double payRate = input.nextDouble();
        System.out.print("Enter federal tax withholding rate:");
        double federalTax = input.nextDouble();
        System.out.print("Enter state tax withholding rate:");
        double stateTax = input.nextDouble();

        System.out.println("Employee Name:" + name);
        System.out.println("Hours Worked:" + workHours);
        System.out.println("Pay Rate: $" + payRate);
        System.out.println("Gross pay: $" + workHours * payRate);
        System.out.println("Deductions:");
        System.out.println("  Federal Withholding (20.0%):" + federalTax * workHours * payRate);
        System.out.println("  State Withholding (9.0%):" + stateTax * workHours * payRate);
        System.out.println("  Total Deduction :" + (federalTax + stateTax) * workHours * payRate);
        System.out.println(" Net Pay: $" + (workHours * payRate - federalTax * workHours * payRate));

        //4.24
        System.out.print("Enter the first country:");
        String country1 = input.next();
        System.out.print("Enter the seconde country:");
        String country2 = input.next();
        System.out.print("Enter the third country:");
        String country3 = input.next();

        if (country1.compareTo(country2) < 0) {
            String temp = country2;
            country2 = country1;
            country1 = temp;
        }
        if (country1.compareTo(country3) < 0) {
            String temp = country3;
            country3 = country1;
            country1 = temp;
        }

        if (country2.compareTo(country3) < 0) {
            String temp = country3;
            country3 = country2;
            country2 = temp;
        }

        System.out.println("The three countries in descending order are " + country1 + " " + country2 + " " + country3);

        //4.25
        System.out.print("This is a vehicle plate number:");
        char ch1 = (char)((int)(Math.random() * 26) + 'A');
        char ch2 = (char)((int)(Math.random() * 26) + 'A');
        char ch3 = (char)((int)(Math.random() * 26) + 'A');

        int num1 = (int)(Math.random() * 10);
        int num2 = (int)(Math.random() * 10);
        int num3 = (int)(Math.random() * 10);
        int num4 = (int)(Math.random() * 10);
        System.out.println("" + ch1 + ch2 + ch3 + num1 + num2 + num3 + num4);




        //4.26


    }
}
