package com.company;

public class Main {
    public static int CYCLE=3;
    public static Game game = new Game();
    public static void main(String[] args) {
	// write your code here

        System.out.println("Round\t\tSleep\t\tRandom\t\tPoints\t\tSleep\t\tRandom\t\tPoints");
        System.out.println("     \t\ttime\t\tcharacter\t\tobtained\t\ttime\t\tcharacter\t\tobtained");

        Thread threadA = new Thread(new TaskA());
        Thread threadB = new Thread(new TaskB());
        Thread threadC = new Thread(new TaskC());

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
