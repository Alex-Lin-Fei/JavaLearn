package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int id;
    private String name;
    private double balance;
    private double annualInterestRate;
    private final Date dateCreated;
    private ArrayList<Transaction> transactions;

    public Account() {
        id = 0;
        name = "";
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
        transactions = new ArrayList<>();
    }

    public Account(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0;
        dateCreated = new Date();
        transactions = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public void withDraw(double amount) {
        if (balance < amount) {
            System.out.println("Sorry, your credit is running low");
            return;
        }
        balance -= amount;
        System.out.println("You have successfully withdrawn $" + amount);
        char type = 'W';
        Date date = new Date();
        String description = date + "\t\t" + type + ": $" + amount + "\t\t balance: $" + balance;
        transactions.add(new Transaction(type, amount, balance, description));
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("You have successfully deposited $" + amount);
        char type = 'D';
        Date date = new Date();
        String description = date + "\t\t" + type + ": $" + amount + "\t\t balance: $" + balance;
        transactions.add(new Transaction(type, amount, balance, description));
    }

    public void accountSummary() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Interest Rate: " + annualInterestRate);
        System.out.println("Balance: " + balance);
        for (Transaction transaction : transactions) {
            transaction.showDescription();
        }
    }
}

class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String  description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        this.date = new Date();
    }

    public void showDescription() {
        System.out.println(description);
    }

}