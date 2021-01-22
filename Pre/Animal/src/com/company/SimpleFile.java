package com.company;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.exit;

public class SimpleFile {
    public static void write(File file) throws IOException, FileNotFoundException {
        Integer num;
        System.out.println("Please enter the number of students");
        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        while (num-- > 0) {
            String number = input.next();
            String name = input.next();
            String sex = input.next();
            String address = input.next();
            String tele = input.next();
            Student student = new Student(number, name, sex, address, tele);
            student.writeStudent(file);
        }
    }
    public static void read(File file) {
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String number = input.next();
                String name = input.next();
                String sex = input.next();
                String address = input.next();
                String tele = input.next();
                Student student = new Student(number, name, sex, address, tele);
                System.out.println(
                        number + "  " + name + "  " + sex + "  " + address + "  " + tele
                );
            }
            input.close();
        }catch (FileNotFoundException e) {}

    }

    public static void main(String[] args) throws Exception{
        File file = new File("D://student.txt");
        System.out.println("1.insert item   2.check    3.exit");
        while (true) {
            System.out.println("enter you choose");
            Scanner input = new Scanner(System.in);
            int c = input.nextInt();
            if (c == 1)
                write(file);
            else if (c == 2)
                read(file);
            else
                exit(0);
        }
    }

}

class Student {
    private String number;
    private String name;
    private String sex;
    private String address;
    private String tele;

    public Student(String number, String name, String sex, String address, String tele) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.tele = tele;
    }

    void writeStudent(File file) throws FileNotFoundException, IOException {
        FileWriter output = new FileWriter(file, true);
        output.write(this.number + "  ");
        output.write(this.name + "  ");
        output.write(this.sex + "  ");
        output.write(this.address + "  ");
        output.write(this.tele + '\n');
        output.close();
    }
}
