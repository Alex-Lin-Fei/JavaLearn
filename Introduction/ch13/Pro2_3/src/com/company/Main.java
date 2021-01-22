package com.company;

import netscape.security.UserTarget;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Number> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++)
            list.add((int) (Math.random() * 10));
        System.out.println(list);
        sort(list);
        System.out.println(list);
        System.out.println(average(list));
        shuffle(list);
        System.out.println(list);
    }

    public static double average(ArrayList<Number> list) {
        double avg = 0.0;
        for (int i = 0; i < list.size(); i++)
            avg += 1.0 * list.get(i).doubleValue() / list.size();
        return avg;
    }

    public static void sort(ArrayList<Number> list) {
        buildHeap(list);
        int heapsize = list.size();
        for (int i = list.size(); i > 1; i--) {
            Number temp = list.get(i - 1);
            list.set(i - 1, list.get(0));
            list.set(0, temp);
            heapsize -= 1;
            maxHeapify(list, 1, heapsize);
        }
    }

    public static void maxHeapify(ArrayList<Number> list, int idx, int heapsize) {
        int l = 2 * idx;
        int r = l + 1;
        int largest;

        if (l <= heapsize && list.get(l - 1).doubleValue() > list.get(idx - 1).doubleValue())
            largest = l;
        else
            largest = idx;
        if (r <= heapsize && list.get(r - 1).doubleValue() > list.get(largest - 1).doubleValue())
            largest = r;
        if (largest != idx) {
            Number temp = list.get(largest - 1);
            list.set(largest - 1, list.get(idx - 1));
            list.set(idx - 1, temp);
            maxHeapify(list, largest, heapsize);
        }
    }

    public static void buildHeap(ArrayList<Number> list) {
        int heapsize = list.size();
        for (int i = list.size() / 2; i >= 1; i--)
            maxHeapify(list, i, heapsize);
    }

    public static void shuffle(ArrayList<Number> list) {
        int len = 0;
        for (int i = 0; i < list.size(); i++) {
            len = i + (int)(Math.random() * (list.size() - i));
            Number temp = list.get(i);
            list.set(i, list.get(len));
            list.set(len, temp);
        }
    }
}
