package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        InClass node1 = new InClass(1);
        InClass node2 = new InClass(2);
        InClass temp = new InClass(node1);
        node1 = node2;
        node2 = temp;
        System.out.println(node1.n + " " + node2.n +" " + temp.n);
        temp.n = 9;
        System.out.println(node1.n + " " + node2.n);
    }
    public static class InClass{
        public int n;
        public InClass() {
            n = 0;
            System.out.println("default");
        }

        public InClass(int x){
            n = x;
            System.out.println("no default " + this.n);
        }

        public InClass(InClass node1) {
             this(node1.n);
        }
    }
}


