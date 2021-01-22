package com.company;

import javafx.scene.Scene;

import java.util.Scanner;
import java.util.Stack;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in=new Scanner(System.in);

        System.out.println("enter the first number please:");
        int numInput1=in.nextInt();
        int[][] table1=factor(numInput1);
        for(int i=0;i<table1.length;i++){
            System.out.println(table1[i][0]+"^"+table1[i][1]);
        }

        System.out.println("enter the second number please");
        int numInput2=in.nextInt();
        factor(numInput2);
        int[][] table2=factor(numInput2);
        for(int i=0;i<table2.length;i++){
            System.out.println(table2[i][0]+"^"+table2[i][1]);
        }

        int temp=1;


        for(int i=0;i<table1.length;++i){
            for(int j=0;j<table2.length;++j){
                if(table1[i][0]==table2[j][0]){
                    temp*=Math.pow(table1[i][0],Math.max(table1[i][1],table2[j][1]));
                    table1[i][0]=table2[j][0]=0;
                    break;
                }
            }
        }

        for(int i=0;i<table1.length;++i){
            if(table1[i][0]!=0){
                temp*=Math.pow(table1[i][0],table1[i][1]);
            }
        }

        for(int i=0;i<table2.length;++i){
            if(table2[i][0]!=0){
                temp*=Math.pow(table2[i][0],table2[i][1]);
            }
        }


        System.out.println("the lcm of two numbers inputted is"+temp);
    }


//    将质因数分解的结果保存在二维数组中
    public static int[][] factor(int num){
//        记录质因子的个数
        int n=0;
        Stack stack=new Stack();

        System.out.println("the result is :");
        for(int i=2;i<=num;i++)
        {
            if(num==1)
                break;
//            如果是该数的质因子
            else if(num%i==0){
                int count=1;
                num/=i;
                while(num%i==0) {
                    count++;
                    num/=i;
                }
//                将质因子和质因子的指数压入栈
                stack.push(count);
                stack.push(i);
                n++;
            }
        }
//        System.out.println(index);
//        for(int i=0;i<=index;i++)
//            System.out.println(table[i][0]+"^"+table[index][1]);
        int[][] table=new int[n][2];
        for(int i=0;i<n;i++){
            table[n-i-1][0]=(int)stack.pop();
            table[n-i-1][1]=(int)stack.pop();
        }
        return table;
    }
}
