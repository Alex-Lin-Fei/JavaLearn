package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Account[] accounts = new Account[10];
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 100);
        }
        Scanner input = new Scanner(System.in);
        while (true) {
            boolean flag = true;
            System.out.println("Enter an id:");
            int id = input.nextInt();
            if (id < 0 || id > 9)
                continue;
            while (flag) {
                System.out.println("Main menu:");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice:");
                int choice = input.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("The balance is " + accounts[id].getBalance());
                    }break;
                    case 2: {
                        System.out.println("Enter an amount to withdraw:");
                        double amount = input.nextDouble();
                        accounts[id].withdraw(amount);
                    }break;
                    case 3: {
                        System.out.println("Enter an amount to deposit:");
                        double amount = input.nextDouble();
                        accounts[id].deposit(amount);
                    }break;
                    case 4: {
                        flag = false;

                    }break;
                    default:break;
                }
            }

        }
    }
}
