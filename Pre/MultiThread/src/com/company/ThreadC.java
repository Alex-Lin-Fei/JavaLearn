package com.company;

public class ThreadC extends Thread {
    public Buff buff;

    public ThreadC(Buff buff1) {
        this.buff = buff1;
    }
    @Override
    public void run(){
        this.buff.C();
    }
}
