package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Stock stock = new Stock("ORCL", "Oracle Corporation");
        stock.setPreviousClosingPrice(34.5);
        stock.setCurrentPrice(34.35);
        System.out.println("The price-change percentage is " + stock.getChangePercent() * 100 + " %");
    }
}
