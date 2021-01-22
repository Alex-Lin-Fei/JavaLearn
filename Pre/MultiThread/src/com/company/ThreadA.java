package com.company;

public class ThreadA implements Runnable {
    public Buff buff;

    public ThreadA(Buff buff1) {
        this.buff = buff1;
    }
    @Override
    public void run(){
        this.buff.A();
    }
}
