package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
       try {
           System.out.println(sum(new int[]{1,2,3,4,5}));
       }catch (Exception ex){
           ex.printStackTrace();
           System.out.println("\n"+ex.getMessage());
           System.out.println("\n" + ex.toString());

           System.out.println("\n trace info obtained from getStackTrace");
           StackTraceElement[] traceElements = ex.getStackTrace();
           for(int i=0;i<traceElements.length;i++){
               System.out.print("method " + traceElements[i].getMethodName());
               System.out.print("(" + traceElements[i].getClassName()+":");
               System.out.println(traceElements[i].getLineNumber()+")");
           }
       }
    }

    private static int sum(int[] list){
        int res = 0;

        for(int i = 0;i<=list.length;i++)
            res+=list[i];

        return res;
    }
}
