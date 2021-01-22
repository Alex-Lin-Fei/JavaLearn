package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Buff buff = new Buff();

        System.out.println("Round\tsleep time\trandom character\tpoint obtained\t\tsleep time\trandom character\tpoints obtained");

        ThreadA threadA = new ThreadA(buff);
        ThreadB threadB = new ThreadB(buff);
        ThreadC threadC = new ThreadC(buff);

        for(int i=0;i<buff.cycle;i++){
            Thread thread1 = new Thread(threadA);
            Thread thread2 = new Thread(threadB);
            Thread thread3 = new Thread(threadC);

            thread1.start();
            thread2.start();
            thread3.start();
        }
    }
}
