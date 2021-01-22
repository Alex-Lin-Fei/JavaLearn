package com.company;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class Server {
    private static int port=8000;
    private static byte[] buff_time=new byte[1024];

    public static void main(String[] args) throws IOException {
	// write your code here
        DatagramSocket socket = new DatagramSocket(port);
        DatagramPacket packet = new DatagramPacket(buff_time, buff_time.length);

        socket.receive(packet);
        String time = new String(packet.getData(),  0, packet.getLength());
        System.out.println("received: " + time);
        socket.close();


    }
}
