package com.example.CurrentTime;

public class FactorialBean {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getFactorial() {
        long factorial = 1;
        for (int i = 2; i <= number; i++)
            factorial *= i;
        return factorial;
    }
}
