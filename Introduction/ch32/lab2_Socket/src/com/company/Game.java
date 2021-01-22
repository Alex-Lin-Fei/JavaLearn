package com.company;

import java.util.Random;

public class Game {
    private int timeA;
    private int timeB;
    private int actionA;
    private int actionB;
    private boolean turnA;
    private boolean turnB;

    public int getTimeA() {
        return timeA;
    }

    public int getTimeB() {
        return timeB;
    }

    public int getActionA() {
        return actionA;
    }

    public int getActionB() {
        return actionB;
    }

    public void setTurnA(boolean turnA) {
        this.turnA = turnA;
    }

    public void setTurnB(boolean turnB) {
        this.turnB = turnB;
    }

    public synchronized void methodA() throws InterruptedException {
        while (!turnA){
            this.wait();
        }
        Random random = new Random();
        timeA = random.nextInt(1000);
        actionA = random.nextInt(3);
        turnA=false;
    }

    public synchronized void methodB() throws InterruptedException {
        while (!turnB){
            this.wait();
        }
        Random random = new Random();
        timeB = random.nextInt(1000);
        actionB = random.nextInt(3);
        turnB=false;
    }
}
