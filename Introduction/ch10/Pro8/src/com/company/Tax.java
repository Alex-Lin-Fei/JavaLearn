package com.company;

public class Tax {
    private int filingStatus;
    private int[][] brackets;
    private double[] rates;
    private double taxableIncome;

    public Tax() {

    }

    public Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }

    public void setFilingStatus(int status) {
        this.filingStatus = status;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public int getFilingStatus() {
        return filingStatus;
    }

    public int[][] getBrackets() {
        return brackets;
    }

    public double[] getRates() {
        return rates;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public double getTax() {
        double tax = 0;
        for (int i = 1; i < 5; i++) {
            if (taxableIncome > brackets[filingStatus][i]) {
                tax += rates[i - 1] * (brackets[filingStatus][i] - brackets[filingStatus][i - 1]);
            }
            else {
                tax += rates[i - 1] * (taxableIncome - brackets[filingStatus][i - 1]);
                break;
            }
        }
        if (taxableIncome > brackets[filingStatus][4])
            tax += rates[4] * (taxableIncome - brackets[filingStatus][4]);

        return tax;
    }



}
