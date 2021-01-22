package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Account account1 = new Account();
        Account account2 = new Account(1, 1000.0);
        account1.setAnnualInterestRate(0.01);
        account2.setAnnualInterestRate(0.02);
        account1.deposit(100);
        account1.withDraw(20);
        System.out.println("account1`s balance is $" + account1.getBalance());
        account2.withDraw(1200);
        account2.deposit(200);
        account2.withDraw(1100);
        System.out.println("The amount2`s balance is $" + account2.getBalance());

    }
}
