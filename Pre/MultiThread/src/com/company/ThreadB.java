package com.company;

public class ThreadB implements Runnable {
    public Buff buff;
    public ThreadB(Buff buff1) {
        this.buff = buff1;
    }
    @Override
    public void run(){
        this.buff.B();
    }
}
