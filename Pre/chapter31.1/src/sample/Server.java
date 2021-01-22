package sample;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.lang.String;
import java.util.*;

public class Server extends JFrame {
    private JTextArea jta = new JTextArea();

    public Server(){
        this.setTitle("Server");
        this.setSize(400,300);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jta.setFont(new Font("Font.ITALIC", Font.PLAIN,15));
        jta.setEditable(false);
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(jta),BorderLayout.CENTER);

        jta.append("server start at "+new Date()+'\n');

        try{
            ServerSocket ss = new ServerSocket(8000);
            Socket socket = ss.accept();

//            获取InetAddress

            InetAddress inetAddress = socket.getInetAddress();
            jta.append("client`s hostname is: "+inetAddress.getHostName());
            jta.append("\n");;
            jta.append("client`s ip is: "+inetAddress.getHostAddress());
            jta.append("\n");;

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            byte[] buf = new byte[1024];
            int len=0;
            while((len = input.read(buf))!=-1){
                double amount = getAmount(new String(buf,0,len));

                jta.append(new String(buf,0,len));

            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

   private static double getAmount(String str){
       String[] str1= str.split("@");

       double rate = Double.parseDouble(str1[0]);
       double year = Double.parseDouble(str1[1]);
       double amount = Double.parseDouble(str1[2]);

       return rate * year * amount + amount;
   }

   public static void main(String[] args){
        JFrame frame = new Server();
   }

}
