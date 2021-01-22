package com.company;

public class TaskC implements Runnable{
    @Override
    public void run() {
        try {
            for (int i = 0; i < Main.CYCLE; i++)
                Main.game.methodC();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
