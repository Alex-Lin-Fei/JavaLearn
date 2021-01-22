package com.company;

import com.sun.corba.se.impl.corba.AsynchInvoke;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static Account account = new Account();
    public static void main(String[] args) {
	// write your code here
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i< 100; i++)
            executor.execute(new AddPenny());
        executor.shutdown();
        while (!executor.isTerminated())
        {

        }
        System.out.println("What is balance? "+account.getBalance());
    }
}

class AddPenny implements Runnable {

    @Override
    public void run() {
        try {
            Main.account.deposit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Account{
    private static final Lock lock = new ReentrantLock();
    private int balance = 0;

    public int getBalance() {return balance;}
    public void deposit(int amount) throws InterruptedException {
        lock.lock();
        ;
        int newBalance = balance + amount;
        Thread.sleep(5);
        balance = newBalance;

        lock.unlock();
    }
}
