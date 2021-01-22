package com.company;

public class ThreadB implements Runnable{
    Data b;
    public ThreadB(Data data){this.b=data;}
    public void run(){
        b.BRound();
    }
}

