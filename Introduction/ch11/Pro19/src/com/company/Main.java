package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of objects: ");
        int num = input.nextInt();
        ArrayList<Container> list = new ArrayList<>();
        System.out.println("Enter the weights of the objects:");
        for (int i = 0; i < num; i++) {
            int temp = input.nextInt();
            if (list.isEmpty()) {
                Container c = new Container();
                c.addItem(temp);
                list.add(c);
            }
            else {
                int k;
                for (k = 0; k < list.size(); k++)
                    if (list.get(k).getCapacity() >= temp) {
                        list.get(k).addItem(temp);
                        break;
                    }
                if (k == list.size()) {
                    Container c = new Container();
                    c.addItem(temp);
                    list.add(c);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print("Container " + (i + 1) +
                    " objects with weight ");
            list.get(i).showContent();
        }


    }
}

class Container {
    private ArrayList<Integer> list;
    private int capacity;

    public Container() {
        list = new ArrayList<>();
        capacity = 10;
    }
    public void addItem(int item) {
        list.add(item);
        this.capacity -= item;
    }
    public void showContent() {
        for (Integer integer : list) System.out.print(integer + " ");
        System.out.println();
    }

    public int getCapacity() {
        return capacity;
    }
}
