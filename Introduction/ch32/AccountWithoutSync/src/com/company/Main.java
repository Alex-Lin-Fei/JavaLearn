package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Account account = new Account();

    public static void main(String[] args) {
        // write your code here
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++)
            executor.execute(new AddPeny());

        executor.shutdown();
        while (!executor.isTerminated()){
        }

        System.out.println("What is balance? " + account.getBalance());
    }

    static class AddPeny implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }
}

class Account {
    private int balance = 0;

    public int getBalance() {
        return balance;
    }
    public void deposit(int amount) {
        int newBalance = balance + amount;
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
        }
        balance = newBalance;
    }
}