package com.company;

import javax.sql.rowset.CachedRowSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException{
	// write your code here
        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    System.out.print(Character.toChars( 'a'+i));
            }
        });

        executor.execute(()->{
            for (int i = 0; i < 20; i++)
                System.out.print(Character.toChars('b'+i));
        });
        executor.shutdown();

        executor.execute(()->{
            for (int i = 0; i < 100; i++)
                System.out.print(i + " ");
        });
        System.out.println();
        Thread.sleep(1000);
        System.out.println("isTerminate: " + executor.isTerminated());
        System.out.println("isShutdown: " + executor.isShutdown());
    }
}
