package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main{
    private Buff mbuf=new Buff();

    public void produce(){
        synchronized (this){
            while(mbuf.isFull()){
                try {
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            mbuf.add();
            notifyAll();
        }
    }

    public void consume(){
        synchronized (this){
            while(mbuf.isEmpty()){
                try {
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            mbuf.remove();
            notifyAll();
        }
    }

    private class Buff{
        private static final int MAX_CAPACITY=1;
        private List innerList=new ArrayList<>(MAX_CAPACITY);

        void add(){
            if(isFull()){
                throw new IndexOutOfBoundsException();
            }
            else{
                innerList.add(new Object());
            }
            System.out.println(Thread.currentThread().getName()+" add");
        }
        void remove(){
            if(isEmpty()){
                throw new IndexOutOfBoundsException();
            }
            else {
               innerList.remove(MAX_CAPACITY-1);
            }
            System.out.println(Thread.currentThread().getName()+" remove");
        }

        boolean isFull(){
            return innerList.size()==MAX_CAPACITY;
        }

        boolean isEmpty(){
            return innerList.isEmpty();
        }
    }

    public static void main(String[] args){
        Main sth=new Main();

        Runnable runProduce=new Runnable() {
            int count=4;
            @Override
            public void run() {
                while(count-->0){
                    sth.produce();
                }
            }
        };

        Runnable runConsumer=new Runnable() {
            int count=4;
            @Override
            public void run() {
                while(count-->0){
                    sth.consume();
                }
            }
        };

        for(int i=0;i<2;i++)
            new Thread(runConsumer).start();
        for(int i=0;i<2;i++)
            new Thread(runProduce).start();
    }
}