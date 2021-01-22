package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("taxable Income\tSingle\tMarried Joint\tMarried Separate\tHead of a House");

        for(int i=50000;i<=60000;i+=50){
            System.out.println("\t"+i+"\t\t"+Single(i)+"\t\t"+MFJ_QW(i)+"\t\t\t"+MFS(i)+"\t\t\t\t"+HofH(i));
        }


    }
//   各种情况下收税情况
//    单身
    public static double Single(double income) {
        double tax=0;

        if(income>0 && income<=7300)
            tax=income*0.1;
        else if(income>7300 && income<=29700)
            tax=730+(income-7300)*0.15;
        else if(income>29700 && income<=71950)
            tax=4090+(income-29700)*0.25;
        else if(income>71950 && income<=150150)
            tax=14652.5+(income-71950)*0.28;
        else if(income>150150 && income<=326450)
            tax=36548.5+(income-150150)*0.33;

        else
            tax=94727.5+(income-326450)*0.35;

        return tax;
    }

//    联姻或符合条件的寡妇
    public static double MFJ_QW(double income){
        double tax=0;

        if(income>0 && income<=14600)
            tax=income*0.1;
        else if(income>14600 && income<=59400)
            tax=1460+(income-14600)*0.15;
        else if(income>59400 && income<=119950)
            tax=8180+(income-59400)*0.25;
        else if(income>119950 && income<=182800)
            tax=23317.5+(income-119950)*0.28;
        else if(income>182800 && income<=326450)
            tax=40915.5+(income-182800)*0.33;
        else
            tax=88320+(income-326450)*0.35;

        return tax;
    }


//   单独归档
    public static double MFS(double income) {
        double tax=0;

        if(income>0 && income<=7300)
            tax=income*0.1;
        else if(income>7300 && income<=29700)
            tax=7300+(income-7300)*0.15;
        else if(income>29700 && income<=59975)
            tax=4090+(income-29700)*0.25;
        else if(income>59975 && income<=91400)
            tax=11658.75+(income-59975)*0.28;
        else if(income>91400 && income<=163225)
            tax=20457.75+(income-91400)*0.33;
        else
            tax=44160+(income-163225)*0.35;

        return tax;
    }


//    户主
    public static double HofH(double income) {
        double tax=0;

        if(income>0 && income<=10450)
            tax=income*0.1;
        else if(income>10450 && income<=39800)
            tax=1045+(income-10450)*0.15;
        else if(income>39800 && income<=102800)
            tax=5447.5+(income-39800)*0.25;
        else if(income>102800 && income<=166450)
            tax=21197.5+(income-102800)*0.28;
        else if(income>166450 && income<=326450)
            tax=39019.5+(income-166450)*0.33;
        else
            tax=91819.5+(income-326450)*0.35;

        return tax;
    }
}
