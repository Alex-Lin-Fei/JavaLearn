package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(2);

    public static void main(String[] args) {
	// write your code here
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();
    }

    private static class ProducerTask implements Runnable {


        @Override
        public void run() {
            try{
                int i = 1;
                while (true) {
                    System.out.println("Producer writes " + i);
                    buffer.put(i++);
                    Thread.sleep((int) (Math.random() * 10000));
                }
            }catch (InterruptedException ex) {

            }
        }
    }
    private static class ConsumerTask implements Runnable {

        @Override
        public void run() {
            try{
                while (true) {
                    System.out.println("\t\tConsumer reads " + buffer.take());
                    Thread.sleep((int) (Math.random() * 10000));
                }
            }catch (InterruptedException ex) {
            }
        }
    }
}
