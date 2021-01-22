package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main{
    static volatile boolean flag=true;
    private synchronized void sub(){
        while(!flag){
            try {
                this.wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        for(int i=0;i<2;i++){
            System.out.println("sub run "+i);
        }
        flag=false;
        this.notify();
    }
    private synchronized void mainRun(){
        while(flag){
            try {
                this.wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        for(int i=0;i<2;i++){
            System.out.println("main run______________________");
        }
        flag=true;
        this.notify();
    }
    public static void main(String[] args){
        Main work=new Main();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    work.sub();
                }
            }
        }).start();
        for(int i=0;i<10;i++)
            work.mainRun();
    }
}