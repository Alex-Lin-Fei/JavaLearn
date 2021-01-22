package com.company;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        String host = "localhost";
        Socket socket = new Socket(host,8000);
        InetAddress inetAddress = socket.getInetAddress();
        System.out.println("Client`s host name is " + inetAddress.getHostName());
        System.out.println("Client`s IP address is " + inetAddress.getHostAddress());

    }
}
