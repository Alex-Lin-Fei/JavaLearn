package com.company;

import java.io.IOException;
import java.net.*;

public class Client {
    private static double time;
    public static void main(String[] args) throws IOException {
        // write your code here
        DatagramSocket socket = new DatagramSocket();
        InetAddress inet = InetAddress.getByName("localhost");
//        String time = String.valueOf(1000*Math.random());
        String time="123";
        DatagramPacket packet = new DatagramPacket(time.getBytes(),time.length(), inet, 8000);
        socket.send(packet);

    }
}
