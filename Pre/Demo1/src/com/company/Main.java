package com.company;

public class Main {
    static class Behavior{
        private int count=1;
        private volatile boolean flag=true;

        public synchronized void printNum(){
            while(!flag){
                try {
                    this.wait();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            System.out.println(count*2-1);
            System.out.println(count*2);
            flag=false;
            this.notify();
        }

        public synchronized void printChar(){
            while(flag){
                try {
                    this.wait();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            System.out.println((char)(count+'A'-1));
            count++;
            flag=true;
            this.notify();
        }
    }

    public static void main(String[] args) {
	// write your code here
        Behavior behavior=new Behavior();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<26;i++)
                    behavior.printNum();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<26;i++)
                    behavior.printChar();
            }
        }).start();
    }
}
