package com.company;

public class Calculator {
    public static void main(String[] args) throws NumberFormatException{
        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            System.exit(1);
        }

        int res = 0;
        switch (args[1].charAt(0)) {
            case '+':
                res = Integer.parseInt(args[0]) +
                        Integer.parseInt(args[2]);
                break;
            case '-':
                res = Integer.parseInt(args[0]) +
                        Integer.parseInt(args[2]);
                break;
            case '*':
                res = Integer.parseInt(args[0]) +
                        Integer.parseInt(args[2]);
                break;
            case '/':
                res = Integer.parseInt(args[0]) +
                        Integer.parseInt(args[2]);
                break;
        }
        System.out.println(args[0] + " " + args[1] + " " + args[2]
                + " = " + res);
    }
}
