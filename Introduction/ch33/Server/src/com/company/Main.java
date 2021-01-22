package com.company;

import com.sun.security.ntlm.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        int port = 8000;
        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        Socket socket;

        server = new ServerSocket(port);
        socket = server.accept();
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        double radius = in.readDouble();
        System.out.println("get radius " + radius);
        out.writeDouble(radius*radius* Math.PI);
    }
}
