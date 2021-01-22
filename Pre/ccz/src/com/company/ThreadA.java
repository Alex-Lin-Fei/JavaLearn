package com.company;

public class ThreadA implements Runnable {
    Data a;
    public ThreadA(Data data){this.a=data;}
    public void run(){
        a.ARound();
    }
}
