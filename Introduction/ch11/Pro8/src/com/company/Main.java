package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Account account = new Account("George", 1122, 1000);
        account.setAnnualInterestRate(0.015);
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        account.withDraw(5);
        account.withDraw(4);
        account.withDraw(2);
        account.accountSummary();
    }
}
