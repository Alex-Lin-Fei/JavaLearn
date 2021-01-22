package com.company;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the URL:");
        String urlString = input.nextLine();
        ArrayList<String> list = new ArrayList<>();

        try {
            URL url = new URL(urlString);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
