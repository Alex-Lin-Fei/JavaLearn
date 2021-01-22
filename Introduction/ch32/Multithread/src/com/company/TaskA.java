package com.company;

public class TaskA implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < Main.CYCLE; i++){
            try {
                Main.game.methodA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
