package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Client {
    private static Game game;

    //    A
    private static Socket socketA;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static int timeA;
    private static int actionA;

    //    B
    private static DatagramSocket socketB;
    private static DatagramPacket packetTime;
    private static DatagramPacket packetAction;
    private static String timeB;
    private static String actionB;

    private static String host = "localhost";
    private static int portA = 8000;
    private static int portB = 8001;

    public static void main(String[] args) throws IOException {
        game = new Game();
        try {
//        A 连接服务器
            socketA = new Socket(host, portA);
            in = new DataInputStream(socketA.getInputStream());
            out = new DataOutputStream(socketA.getOutputStream());
        } catch (IOException ignored) {
        }


//        B连接服务器
        socketB = new DatagramSocket();


        for (int i = 0; i < CONSTANTS.ROUND; i++) {
//            服务器示意开始游戏
            in.readInt();
            game.setTurnA(true);
            game.setTurnB(true);

            new Thread(() -> {
                try {
                    game.methodA();
                    timeA = game.getTimeA();
                    actionA = game.getActionA();
                    out.writeInt(timeA);
                    out.writeInt(actionA);
                } catch (InterruptedException | IOException ignored) {
                }
            }).start();
            new Thread(() -> {
                try {
                    game.methodB();
                    timeB = String.valueOf(game.getTimeB());
                    actionB = String.valueOf(game.getActionB());
                    packetTime = new DatagramPacket(timeB.getBytes(), timeB.length(),
                            InetAddress.getByName(host), portB);
                    packetAction = new DatagramPacket(actionB.getBytes(), actionB.length(),
                            InetAddress.getByName(host), portB);
                    socketB.send(packetTime);
                    socketB.send(packetAction);
                } catch (InterruptedException | UnknownHostException ignored) {
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
