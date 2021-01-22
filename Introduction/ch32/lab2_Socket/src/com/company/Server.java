package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
//    A
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static DataInputStream fromClient;
    private static DataOutputStream toClient;
    private static int timeA;
    private static int actionA;
    private static int pointA=0;

//    B
    private static DatagramSocket datagramSocket;
    private static DatagramPacket packetTime;
    private static DatagramPacket packetAction;
    private static byte[] buff_time = new byte[1024];
    private static byte[] buff_action = new byte[1024];
    private static int timeB;
    private static int actionB;
    private static int pointB=0;

    private static int portA = 8000;
    private static int portB = 8001;


    private static int diff=0;

    public static void main(String[] args) throws IOException {
//            接收A 的连接
            serverSocket = new ServerSocket(portA);
            socket = serverSocket.accept();
            fromClient = new DataInputStream(socket.getInputStream());
            toClient = new DataOutputStream(socket.getOutputStream());

//            接收 B 的连接
        datagramSocket = new DatagramSocket(portB);

        System.out.println("Round\t\tSleep\t\tRandom\t\tPoints\t\tSleep\t\tRandom\t\tPoints");
        System.out.println("     \t\ttime\t\tselection\t\tobtained\t\ttime\t\tselection\t\tobtained");

        for (int i = 0; i < CONSTANTS.ROUND; i++) {
//            示意开始游戏
            toClient.writeInt(1);

//            接收 A
            timeA = fromClient.readInt();
            actionA = fromClient.readInt();

//            接收 B
            packetTime = new DatagramPacket(buff_time,buff_time.length);
            datagramSocket.receive(packetTime);
            String time = new String(packetTime.getData(),0,packetTime.getLength());
            timeB = Integer.parseInt(time);
            packetAction = new DatagramPacket(buff_action,buff_action.length);
            datagramSocket.receive(packetAction);
            String num = new String(packetAction.getData(), 0, packetAction.getLength());
            actionB = Integer.parseInt(num);

//           输出结果并比较
            if (actionA == actionB)
                pointA = pointB = 1;
            else if ((actionA+1)%3 == actionB)
                pointA = 2;
            else
                pointB = 2;
            String A =getAction(actionA);
            String B = getAction(actionB);

            System.out.println((i+1) + "\t\t" + timeA +"ms\t\t" +A + "\t\t"
            +pointA+"\t\t" + timeB +"ms\t\t" + B+"\t\t"+pointB);
            diff = pointA-pointB;
            pointB = pointA = 0;
        }
        String winner;
        if (diff < 0)
            winner = "Kid B";
        else if (diff>0)
            winner = "Kid A";
        else
            winner = "None";
        System.out.println(winner + " is the winner");

    }
    public static String getAction(int s) {
        switch (s) {
            case 0:
                return "ROCK";
            case 1:
                return "SCISSORS";
            case 2:
                return "PAPER";
        }
        return "";
    }
}
