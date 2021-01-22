package com.company;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayList<String> collection = new ArrayList<>();
        collection.add("new york");
        collection.add("atlanta");
        collection.add("dallas");
        collection.add("madison");

        System.out.println("a list of cities in collection: ");
        System.out.println(collection);

        System.out.println("\nIs dallas in collection? "+collection.contains("dallas"));
        collection.remove("dallas");
        System.out.println("\n"+collection.size()+" cities are in collection now");

        Collection<String> collection1 = new ArrayList<>();
        collection1.add("seattle");
        collection1.add("portland");
        collection1.add("los angeles");
        collection1.add("atlanta");

        System.out.println("\n a list of cities in collection1:");
        System.out.println(collection1);

        ArrayList<String> c1 = (ArrayList<String>)(collection.clone());
        c1.addAll(collection1);
        System.out.println("\ncities in collection or collection1:");
        System.out.println(c1);

        Iterator<String> iterator = c1.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next().toUpperCase());
        System.out.println();

        c1=(ArrayList<String>)(collection.clone());
        c1.retainAll(collection1);
        System.out.print("\nCities in collection1 and collection2");
        System.out.println(c1);

        c1=(ArrayList<String>)(collection.clone());
        c1.removeAll(collection1);
        System.out.print("\ncities in collection1,but not in 2:");
        System.out.println(c1);

        String str = String.format("%5.2f %5.2f",45.556,223.228);
        System.out.println(str);
    }

}
