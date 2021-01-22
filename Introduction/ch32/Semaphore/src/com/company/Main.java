package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    private static class Account {
        private static Semaphore semaphore = new Semaphore(1);
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            try{
                semaphore.acquire();
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance;
            }catch (InterruptedException ex) {

            }
            finally {
                semaphore.release();
            }
        }
    }
}
