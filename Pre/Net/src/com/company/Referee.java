package com.company;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Referee implements Var {
    private static GamePackage data=new GamePackage();
    public static void main(String[] argv){

        // 玩家A  以TCP协议发送数据
        new Thread(()->{
            while (true)
                try {
//                    创建服务器套接字  端口为TCP端口
                    ServerSocket serverSocket = new ServerSocket(TCP_PORT);
                    Socket socket = serverSocket.accept();
//                    获取ip地址
                    InetAddress inetAddress = socket.getInetAddress();
//                    本机地址
                    System.out.println("\nRock-Paper-Scissors game starts at IP: " + inetAddress.getHostAddress());
//                    获取输入的数据
                    ObjectInputStream fromPlayer = new ObjectInputStream(socket.getInputStream());

                    for (int i = 0; i < TIMES ; i++) {
                        String res=fromPlayer.readObject().toString();
                        data.updateA(res);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
        }).start();

        // 玩家B  以UDP 协议发送数据包
        new Thread(()->{
            byte[] buf = new byte[1024];
            while (true)
                try {
//                    构造数据报套接字  并绑定到UDP端口
                    DatagramSocket socket = new DatagramSocket(UDP_PORT);
//                    接受数据包
                    DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);

                    for (int i = 0; i < TIMES ; i++) {
                        Arrays.fill(buf, (byte) 0);
//                        接受数据包
                        socket.receive(receivePacket);
//                        更新B中内容
                        data.updateB(new String(buf).trim());
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }).start();
    }
}

class GamePackage implements Var {
    //    创建两个ArrayList动态数组
    private ArrayList<String> dataA = new ArrayList<>();
    private ArrayList<String> dataB = new ArrayList<>();
    //   初始化数据 A B玩家分数  游戏轮数
    private int round = 0;
    private int scoreA;
    private int scoreB;

    //    A玩家游戏更新
    void updateA(String str) {
//        添加玩家的sleep时间和trick 组成的信息字符串
        dataA.add(str);
//        判断  如果两个人的轮数均大于了round  则输出这一轮比赛结果
        if (dataA.size() > round && dataB.size() > round)
            result(round++);
    }

    void updateB(String str) {
        //        添加玩家的sleep时间和trick 组成的信息字符串
        dataB.add(str);
        //        判断  如果两个人的轮数均大于了round  则输出这一轮比赛结果
        if (dataA.size() > round && dataB.size() > round)
            result(round++);
    }

    private void result(int round) {
        if (round == 0) {
            System.out.println("\t\t\t\tThread A\t\t\t\tThread B");
            System.out.println("Round\tSleep\tRandom\tPoints\tSleep\tRandom\tPoints\t");
            System.out.println("\t\ttime\tselect\tobtained\ttime\tselect\tobtained\t");
        }
        String[] a = dataA.get(round).split(" ");
        String[] b = dataB.get(round).split(" ");

        int res = compare(a[1], b[1]);
        switch (res) {
            case 0: {
                System.out.println((round + 1) + "\t\t" + a[0] + "\t\t" + a[1] + "\t" + 1 + "\t\t" + b[0] + "\t\t" + b[1] + "\t" + 1);
                scoreA++;
                scoreB++;
            }
            break;
            case 1: {
                System.out.println((round + 1) + "\t\t" + a[0] + "\t\t" + a[1] + "\t" + 2 + "\t\t" + b[0] + "\t\t" + b[1] + "\t" + 0);
                scoreA += 2;
            }
            break;
            case -1: {
                System.out.println((round + 1) + "\t\t" + a[0] + "\t\t" + a[1] + "\t" + 0 + "\t\t" + b[0] + "\t\t" + b[1] + "\t" + 2);
                scoreB += 2;
            }
            break;
            default:
                break;
        }
        if (round == TIMES - 1) {
            if (scoreA > scoreB)
                System.out.println("A is the winner");
            else if (scoreB > scoreA)
                System.out.println("B is the winner");
            else System.out.println("None is the winner");

            this.round = 0;
            scoreA = 0;
            scoreB = 0;
            dataA.clear();
            dataB.clear();
        }
    }

    private int compare(String str1, String str2) {
        if (str1.equals(str2))
            return 0;
        else if ((str1.equals("ROCK") && str2.equals("SCISSORS")) || (str1.equals("SCISSORS") && str2.equals("PAPER"))
                || (str1.equals("PAPER") && str2.equals("ROCK")))
            return 1;
        else
            return -1;
    }
}


/*
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Referee implements Var {
    static GameData data=new GameData();
    public static void main(String[] argv){
        // 玩家A  以TCP协议发送数据
        new Thread(()->{
            while (true)
                try {
                    //                    创建服务器套接字  端口为TCP端口
                    ServerSocket serverSocket = new ServerSocket(TCP_PORT);
                    Socket socket = serverSocket.accept();
                    //                    获取ip地址
                    InetAddress inetAddress = socket.getInetAddress();
                    //                    本机地址
                    System.out.println("\nRock-Paper-Scissors game starts at IP: " + inetAddress.getHostAddress());
                    ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
                    // ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
                    for (int i = 0; i < TIMES ; i++) {
                        String gotStr=inputFromClient.readObject().toString();
                        //System.out.println("tcp"+gotStr);
                        data.updateA(gotStr);
                    }
                } catch (IOException | ClassNotFoundException ignored) {
                }
        }).start();
        // 接受UDP
        new Thread(()->{
            byte[] buf = new byte[64];
            while (true)
                try {
                    DatagramSocket socket = new DatagramSocket(UDP_PORT);
                    DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
                    for (int i = 0; i < TIMES ; i++) {
                        Arrays.fill(buf, (byte) 0); // Initialize buffer for each iteration
                        socket.receive(receivePacket); // Receive from the client in a packet
                        //System.out.println("udp"+new String(buf).trim());
                        data.updateB(new String(buf).trim());
                    }
                } catch (IOException ignored) {
                }
        }).start();
    }
}

class GameData implements Var{
    private ArrayList<String> dataA=new ArrayList<>();
    private ArrayList<String> dataB=new ArrayList<>();
    private int round=0,scoreA=0,scoreB=0;
    void updateA(String str){
        dataA.add(str);
        if(dataA.size()>round&&dataB.size()>round) print(round++);
    }
    void updateB(String str){
        dataB.add(str);
        if(dataA.size()>round&&dataB.size()>round) print(round++);
    }
    void print(int round){
        if(round==0){
            System.out.println("\t\t\t\tThread A\t\t\t\tThread B");
            System.out.println("Round\tSleep\tRandom\tPoints\tSleep\tRandom\tPoints\t");
            System.out.println("\t\ttime\tselect\tobtain\ttime\tselect\tobtain\t");
        }
        String[] a=dataA.get(round).split(" ");
        String[] b=dataB.get(round).split(" ");

//        if (a[1].equals(b[1])) {
//            System.out.println((round+1)+"\t\t"+a[0]+"\t\t"+a[1]+"\t"+1+"\t\t"+b[0]+"\t\t"+b[1]+"\t"+1);
//            aScore++;
//            bScore++;
//        } else if ((a[1].equals("ROCK")&&b[1].equals("PAPER"))||(a[1].equals("PAPER")&&b[1].equals("SCISSORS"))
//                ||(a[1].equals("SCISSORS")&&b[1].equals("ROCK"))) {
//            System.out.println((round+1)+"\t\t"+a[0]+"\t\t"+a[1]+"\t"+0+"\t\t"+b[0]+"\t\t"+b[1]+"\t"+2);
//            bScore += 2;
//        } else {
//            System.out.println((round+1)+"\t\t"+a[0]+"\t\t"+a[1]+"\t"+2+"\t\t"+b[0]+"\t\t"+b[1]+"\t"+0);
//            aScore += 2;
//        }
                int res = compare(a[1],b[1]);
        switch (res){
            case 0:{
                System.out.println((round+1)+"\t\t"+a[0]+"\t\t"+a[1]+"\t"+1+"\t\t"+b[0]+"\t\t"+b[1]+"\t"+1);
                scoreA++;
                scoreB++;
            }
            break;
            case 1: {
                System.out.println((round+1)+"\t\t"+a[0]+"\t\t"+a[1]+"\t"+2+"\t\t"+b[0]+"\t\t"+b[1]+"\t"+0);
                scoreA+=2;
            }
            break;
            case -1:{
                System.out.println((round+1)+"\t\t"+a[0]+"\t\t"+a[1]+"\t"+0+"\t\t"+b[0]+"\t\t"+b[1]+"\t"+2);
                scoreB+=2;
            }
            break;
            default:break;
        }

        if(round==TIMES-1){
            if(scoreA>scoreB)System.out.println("A is the winner");
            else if(scoreA<scoreB)System.out.println("B is the winner");
            else System.out.println("None is the winner");
            // reset and ready for a new game
            this.round=scoreA=scoreB=0;
            dataA.clear();
            dataB.clear();
        }
    }
    private int compare(String str1,String str2){
        if(str1.equals(str2))
            return 0;
        else if( ( str1.equals("ROCK") && str2.equals("SCISSORS")) || ( str1.equals("SCISSORS") && str2.equals("PAPER"))
        || (str1.equals("PAPER") && str2.equals("ROCK")))
            return 1;
        else
            return -1;
    }
}
*/