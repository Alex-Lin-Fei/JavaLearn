package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String args[]){
        DataInputStream in;
        DataOutputStream out;
        Socket socket;
        Data data=new Data();
        try {
            socket=new Socket("localhost",8000);
            in=new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());//TCP

            String num;
            String sleeptime;
            int port1=8080;
            int port2=8888;
            DatagramSocket socket2;
            DatagramPacket packet1,packet2;
            socket2 =new DatagramSocket(port2);
            InetAddress inetAddress=InetAddress.getLocalHost();//UDP

            for(int i=0;i<3;i++){//进行三次比赛
                ThreadA threadA=new ThreadA(data);
                ThreadB threadB=new ThreadB(data);
                new Thread(threadA).start();
                new Thread(threadB).start();
                while(!(data.isAProduced()&&data.isBProdeuce())){System.out.print("");}//当A,B都执行完，再发送数值
                System.out.println(data.getA());
                System.out.println(data.getB());
                out.writeBoolean(true);
                out.writeInt(data.getA());
                out.writeLong(data.getASleeptime());//TCP发送

                num=String.valueOf(data.getB());
                sleeptime=String.valueOf(data.getBSleeptime());
                packet1=new DatagramPacket(num.getBytes(),num.length(),inetAddress,port1);
                socket2.send(packet1);
                packet2=new DatagramPacket(sleeptime.getBytes(),sleeptime.length(),inetAddress,port1);
                socket2.send(packet2);//UDP发送

                Boolean serveFinished=false;
                serveFinished=in.readBoolean();
                while(!serveFinished){System.out.print("");}//等待server处理完，A，B再继续执行
                data.setAProduced(false);
                data.setBProduced(false);
            }//for
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
