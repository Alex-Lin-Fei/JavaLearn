package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {
    public static void main(String args[]) throws SocketException {
        String selection_A = " ";
        String selection_B=" ";
        int points_A=0;
        int points_B=0;
        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        Socket socket;//TCP

        int port=8080;
        DatagramSocket socket2;
        DatagramPacket packet1,packet2;
        byte[] buf_num=new byte[1024];
        byte[] buf_sleeptime=new byte[1024];
        socket2=new DatagramSocket(port);
        packet1=new DatagramPacket(buf_num,1024);
        packet2=new DatagramPacket(buf_sleeptime,1024);//UDP
        boolean produced=false;
        try {
            server = new ServerSocket(8000);
            socket=server.accept();
            in=new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());

            for(int i=0;i<3;i++){//进行三轮比赛
                produced=in.readBoolean();
                int num_A=in.readInt();
                long sleeptime_A=in.readLong();//TCP

                socket2.receive(packet1);
                String String_num=new String(buf_num);
                int num_B=Integer.parseInt(String_num.trim());
                packet1.setLength(1024);
                socket2.receive(packet2);
                String String_sleeptime=new String(buf_sleeptime);
                int sleeptime_B=Integer.parseInt(String_sleeptime.trim());
                packet2.setLength(1024);//UDP

                while(!produced){System.out.print("");}//等待A,B线程执行完，进行比较与输出操作
                if(num_A==0){
                    selection_A="rock";
                    switch (num_B){
                        case 0:selection_B="rock";break;
                        case 1:selection_B="scissors";points_A++;break;
                        case 2:selection_B="paper";;points_B++;break;
                    }
                }
                if(num_A==1){
                    selection_A="scissors";
                    switch (num_B){
                        case 0:selection_B="rock";points_B++;break;
                        case 1:selection_B="scissors";break;
                        case 2:selection_B="paper";;points_A++;break;
                    }
                }
                if(num_A==2){
                    selection_A="paper";
                    switch (num_B){
                        case 0:selection_B="rock";points_A++;break;
                        case 1:selection_B="scissors";points_B++;break;
                        case 2:selection_B="paper";break;
                    }
                }
                System.out.println("                             ThreadA                                     ThreadB");
                System.out.println("           sleeptime        selection      points      sleeptime        selection     points        ");
                System.out.println("round"+(i+1)+"     "+sleeptime_A+"              "+selection_A+"            "+points_A+"       "+sleeptime_B+"              "+selection_B+"            "+points_B);
                out.writeBoolean(true);}//给CLIENT发信号，使A,B继续运行
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

