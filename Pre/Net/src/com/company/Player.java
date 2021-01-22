package com.company;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

public class Player implements Var{
    public static void main(String[] argv) {
            new ThreadA("localhost").start();
            new ThreadB("localhost").start();
    }
}

class ThreadA extends Thread implements Var {
    private ObjectOutputStream toReferee = null;
    private String host;

    public ThreadA(String host) {
        this.host = host;
    }

   @Override
    public void run(){
       try{
           Socket socket = new Socket(host,TCP_PORT);
           toReferee = new ObjectOutputStream(socket.getOutputStream());

           for(int i=0;i<TIMES;i++){
               int time = (int)(Math.random()*1000);
               int trick = (int)(Math.random()*3);

               sleep(time);

               switch (trick){
                   case 0:toReferee.writeObject(time+" "+"ROCK");
                   break;
                   case 1:toReferee.writeObject(time+" "+"SCISSORS");
                   break;
                   case 2:toReferee.writeObject(time+" "+"PAPER");
                   break;
                   default:break;
               }
           }
           socket.close();

       }catch (IOException|InterruptedException ex){
           ex.printStackTrace();
       }
   }
}

class ThreadB extends Thread implements Var {
    private byte[] buff = new byte[1024];
    private String host;

    public ThreadB(String host) {
        this.host = host;
    }

    @Override
    public void run() {
        try {
//            初始化buff数据
            Arrays.fill(buff, (byte) 0);
//            创建发送端socket对象
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName(host);
//            创建数据包
            DatagramPacket toReferee = new DatagramPacket(buff, buff.length, address, UDP_PORT);

            for (int i = 0; i < TIMES; i++) {
                int time = (int) (Math.random() * 1000);
                int trick = (int) (Math.random() * 3);

                sleep(time);

                switch (trick) {
                    case 0:
                        toReferee.setData((time + " " + "ROCK").getBytes());
                        break;
                    case 1:
                        toReferee.setData((time + " " + "SCISSORS").getBytes());
                        break;
                    case 2:
                        toReferee.setData((time + " " + "PAPER").getBytes());
                        break;
                    default:
                        break;
                }
                socket.send(toReferee);
            }
            socket.close();

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
