package com.company;

import com.sun.corba.se.impl.encoding.CodeSetConversion;

import java.util.concurrent.atomic.AtomicBoolean;

public class Game {
    private boolean turnA=true;
    private boolean turnB=true;

    private char charA;
    private char charB;

    private double timeA;
    private double timeB;

    private int pointA;
    private int pointB;

    private int diff;
    private int round=0;

    public Game() {
    }


    public void methodA() throws InterruptedException {
        synchronized (this) {
            while (!turnA) {
                this.wait();
            }

            charA = (char) (Math.random() * 26 + 97);
            timeA = Math.random();
            Thread.sleep((long) (timeA*1000));
            turnA = false;
            this.notifyAll();
        }
    }

    public void methodB() throws InterruptedException{
        synchronized (this) {
            while (!turnB) {
                this.wait();
            }
            charB = (char) (Math.random() * 26 + 97);
            timeB = Math.random();
            Thread.sleep((long)(timeB*1000));
            turnB = false;
            this.notifyAll();
        }
    }

    public void methodC() throws InterruptedException {
        synchronized (this) {
            while (turnA || turnB) {
                this.wait();
            }

            if (charA > charB)
                pointA = 2;
            else if (charA < charB)
                pointB = 2;
            else {
                pointA=1;
                pointB=1;
            }
            diff += pointA - pointB;
            round++;
            if (round <= Main.CYCLE) {
                System.out.println(round + "\t\t" + timeA + "\t\t" + charA + "\t\t"
                        + pointA + "\t\t" + timeB + "\t\t" + charB + "\t\t" + pointB);
            }
//        结束
            if (round == Main.CYCLE) {
                String winner;
                if (diff < 0)
                    winner = "B";
                else if (diff > 0)
                    winner = "A";
                else
                    winner = "None";
                System.out.println(winner + " is the winner");
            }
            turnA = true;
            turnB = true;
            pointA=0;
            pointB=0;
            this.notifyAll();
        }
    }
}
