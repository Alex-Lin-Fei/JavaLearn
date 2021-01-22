package com.company;

import java.io.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,IOException{
	// write your code here
       RandomAccessFile inout = new RandomAccessFile("inout.dat","rw");
       inout.setLength(0);;

       for(int i=0;i<100;i++)
           inout.writeInt(i);

       System.out.println("Current file length is "+inout.length());
       inout.seek(0);
       System.out.println("The first number is "+inout.readInt());
       inout.seek( 1 * 4);
       System.out.println("the second number is "+inout.readInt());

       inout.seek(9 * 4);
       System.out.println("the tenth number is "+inout.readInt());
       inout.writeInt(555);

       inout.seek(inout.length());
       inout.writeInt(999);

       System.out.println("now the length is "+inout.length());
       inout.seek(10 * 4);
       System.out.println("the eleventh number is "+inout.readInt());
       System.out.println(inout.readInt());

       inout.close();
    }
}