package com.company;

import java.util.Random;

public class Data {
    private boolean AProduced=false;
    private boolean BProduced=false;
    private long ASleeptime=0;
    private long BSleeptime=0;
    private int A;
    private int B;
    private int APoints;
    private int BPoints;
    public Data(){}

    public void setAProduced(boolean AProduced) {
        this.AProduced = AProduced;
    }

    public void setBProduced(boolean BProduced) {
        this.BProduced = BProduced;
    }

    public boolean isAProduced() {
        return AProduced;
    }

    public boolean isBProdeuce() {
        return BProduced;
    }

    public void setASleeptime(long ASleeptime){this.ASleeptime=ASleeptime;}

    public long getASleeptime() {
        return ASleeptime;
    }

    public long getBSleeptime() {
        return BSleeptime;
    }

    public void setBSleeptime(long BSleeptime) { this.BSleeptime=BSleeptime; }

    public void setA(int A) {
        this.A = A;
    }

    public int getA() {
        return A;
    }

    public void setB(int B) {
        this.B = B;
    }

    public int getB() {
        return B;
    }

    public void setAPoints() {
        this.APoints++;
    }

    public int getAPoints() {
        return APoints;
    }

    public void setBPoints() {
        this.BPoints++;
    }

    public int getBPoints() {
        return BPoints;
    }
    synchronized public void ARound(){
        while(isAProduced()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while
        Random r=new Random();
        long time=r.nextInt(1000);
        setASleeptime(time);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A sleep for "+getASleeptime());
        Random rand=new Random();
        int c=rand.nextInt(3);
        setA(c);
        AProduced=true;
        notifyAll();
    }
    synchronized public void BRound(){
        while(isBProdeuce()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while
        Random r=new Random(1);
        long time=r.nextInt(1000);
        setBSleeptime(time);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B sleep for "+getBSleeptime());
        Random rand=new Random();
        int c=rand.nextInt(3);
        setB(c);
        BProduced=true;
        notifyAll();
    }
}