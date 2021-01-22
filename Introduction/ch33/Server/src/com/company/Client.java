package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        int port = 8000;
        String host = "localhost";
        DataInputStream in;
        DataOutputStream out;
        Socket socket;

        socket = new Socket(host, port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        Double radius = scanner.nextDouble();
        out.writeDouble(radius);
        System.out.println("radius " + radius + " area = " + in.readDouble());
    }
}
