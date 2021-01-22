package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("*********************");
        //1.1
        System.out.println("Welcome to Java");
        System.out.println("Learning Java now");
        System.out.println("Programming is fun");

        System.out.println("*********************");
        //1.2
        for (int i = 0; i < 5; i++) {
            System.out.println("I love Java");
        }

        System.out.println("*********************");
        //1.3
        System.out.println("   J");
        System.out.println("J  aaa    v     vaaa");
        System.out.println("J  J  AA    V V    a a");
        System.out.println("J   aaaa     v     aaaa");

        System.out.println("*********************");
        //1.4
        System.out.println("a\ta^2\ta^3\ta^4");
        for (int i = 1; i <= 4; i++)
            System.out.println(i + "\t" + i * i + "\t" + i * i * i + "\t" + i * i * i * i);

        System.out.println("*********************");
        //1.5
        System.out.println((7.5 * 6.5 - 4.5 * 3) / (47.5 - 5.5));

        System.out.println("*********************");
        //1.6
        int i = 1;
        int sum = 0;
        while (i < 10)
            sum += i++;
        System.out.println(sum);

        System.out.println("*********************");
        //1.7
        int fu = 1;
        double ans = 0;
        for (int j = 1; j <= 11; j += 2) {
            ans += fu * 1.0 / j;
            fu *= -1;
        }
        ans *= 4;
        System.out.println(ans);

        System.out.println("*********************");
        //1.8
        double P = 3.14159;
        System.out.println(P * 6.5 * 2);
        System.out.println(6.5 * 6.5 * P);

        System.out.println("*********************");
        //1.9
        double w = 5.3;
        double h = 8.6;
        System.out.println(w * h);
        System.out.println(2 * (w + h));

        System.out.println("*********************");
        //1.10
        double k = 15;
        double min = 50;
        double s = 30;
        double hour = (min * 60 + s) / 3600;
        double mile = k / 1.6;
        System.out.println(mile / hour);

        System.out.println("*********************");
        //1.11
        int birth = 7;
        int death = 13;
        int imm = 45;
        int now = 2020;
        double year = 365;
        double population = 312032486;
        System.out.println("Year\tBirth\tDeath\tImmigrant\tSum");
        for (int y = 1; y <= 5; y++) {
            now++;
            double new_birth = (year * 24 * 3600) / birth;
            double new_death = (year * 24 * 3600) / death;
            double new_imm = (year * 24 * 3600) / imm;
            population += new_birth - new_death + new_imm;
            System.out.println(now + "\t" + new_birth
                   + "\t" + new_death + "\t" + new_imm + "\t" + population);
        }



        System.out.println("*********************");
        //1.12
        double x = 24 * 1.6;
        double h1 = 1;
        double h2 = 2.0 / 3;
        double h3 = 7.0 / 12;
        System.out.println(x / h1 + " " + x / h2 + " " + x / h3);
    }
}
