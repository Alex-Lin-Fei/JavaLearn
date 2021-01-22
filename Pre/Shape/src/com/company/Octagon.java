package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private int side = 1;

    public Octagon(int side) {
        this.side = side;
    }

    public int getSide() {
        return this.side;
    }

    public double getArea() {
        return (double)(this.side * this.side) * (2.0D + 4.0D * Math.sqrt(2.0D));
    }

    public int getPerimeter() {
        return 8 * this.side;
    }

    public int compareTo(Octagon o) {
        if (this.getSide() > o.getSide()) {
            return 1;
        } else {
            return this.getSide() < o.getSide() ? -1 : 0;
        }
    }
}
