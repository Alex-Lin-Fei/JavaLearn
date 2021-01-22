package com.company;

public class TaskB implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < Main.CYCLE; i++) {
            try {
                Main.game.methodB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
