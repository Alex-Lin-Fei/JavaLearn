package com.company;

public class Buff {
    public final int cycle = 3;
    private int count = 0;
    private int res = 0;
    private long timeA;
    private long timeB;
    private char chA;
    private char chB;
    private int pointA;
    private int pointB;
    private boolean isConsumeA = true;
    private boolean isConsumeB = true;


    public void setTimeA(long time) {
        this.timeA = time;
    }

    public void setTimeB(long time) {
        this.timeB = time;
    }

    public void setChA(char ch) {
        this.chA = ch;
    }

    public void setChB(char ch) {
        this.chB = ch;
    }

    public long getTimeA() {
        return timeA;
    }

    public long getTimeB() {
        return timeB;
    }

    public char getChA() {
        return chA;
    }

    public char getChB() {
        return chB;
    }

    public int getPointA() {
        return pointA;
    }

    public int getPointB() {
        return pointB;
    }

    public void setPointA(int point) {
        this.pointA = point;
    }

    public void setPointB(int point) {
        this.pointB = point;
    }

    public synchronized void A() {
        while (!isConsumeA) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        long time = (long) (Math.random() * 1000 + 1);
        char ch = (char) (Math.random() * 26 + 97);
        this.setTimeA(time);
        this.setChA(ch);
        this.isConsumeA = false;
        this.notifyAll();
    }

    public synchronized void B() {
        while (!isConsumeB) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        long time = (long) (Math.random() * 1000 + 1);
        char ch = (char) (int) (Math.random() * 26 + 97);
        this.setTimeB(time);
        this.setChB(ch);
        this.isConsumeB = false;
        this.notifyAll();
    }

    public synchronized void C() {
        while (isConsumeA || isConsumeB) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        int cmp = Double.compare(this.getChA(), this.getChB());
        switch (cmp) {
            case 0: {
                this.setPointA(1);
                this.setPointB(1);
            }
            break;
            case 1: {
                this.setPointA(2);
                this.setPointB(0);
            }
            break;
            case -1: {
                this.setPointA(0);
                this.setPointB(2);
            }
            break;
            default:
                break;
        }
        res += this.pointA - this.pointB;
        count++;
        if (count <= this.cycle)
            System.out.println("  " + count + "\t\t\t" + getTimeA() + "\t\t\t" + getChA() + "\t\t\t\t\t" + getPointA() + "\t\t\t\t\t" + getTimeB() + "\t\t\t" + getChB() + "\t\t\t\t\t" + getPointB());
        if (count == this.cycle) {
            if (res < 0)
                System.out.println("B is the winner");
            else if (res > 0)
                System.out.println("A is the winner");
            else
                System.out.println("None is the winner");
        }
        this.isConsumeA = true;
        this.isConsumeB = true;
        this.notifyAll();
    }
}
