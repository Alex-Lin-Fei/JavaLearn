package com.company;

import sun.awt.geom.AreaOp;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {
    private static  Buffer buffer = new Buffer();

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new Producer());
        executor.execute(new Consumer());
        executor.shutdown();
    }


    private static class Consumer implements Runnable {
        public void run() {
            try {
                while (true) {
                    System.out.println("\t\t\tConsumer reads " + buffer.read());
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class Producer implements Runnable {
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("producer writes " + i);
                    buffer.write(i++);
                    Thread.sleep((int) (Math.random() * 1000));
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class Buffer {
        private static final int CAPACITY = 1;
        private java.util.LinkedList<Integer> queue = new java.util.LinkedList<>();

        private static Lock lock = new ReentrantLock();
        private static Condition notEmpty = lock.newCondition();
        private static Condition notFull = lock.newCondition();

        public void write(int val){
            lock.lock();
            try {
                while(queue.size() == CAPACITY)
                {
                    System.out.println("wait for not full condition");
                    notFull.await();
                }
                queue.offer(val);
                notEmpty.signal();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }


        public int read(){
            int val = 0;
            lock.lock();
            try {
                while(queue.isEmpty()){
                    System.out.println("\t\t\twait for notEmpty condition");
                    notEmpty.await();
                }
                val = queue.remove();
                notFull.signal();
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
            finally {
                lock.unlock();
                return val;
            }
        }


    }
}