package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Client extends JFrame {
    private JPanel center = new JPanel();
    private JPanel south = new JPanel();

    private JTextArea jta = new JTextArea();
    private JButton jbt = new JButton("Submit");

    private JLabel jlb1 = new JLabel("taxrate");
    private JTextField rate = new JTextField();
    private JLabel jlb2 = new JLabel("years");
    private JTextField year = new JTextField();
    private JLabel jlb3 = new JLabel("sum");
    private JTextField amount = new JTextField();

    public Client(){
//        设计GUI布局
        center.setLayout(new GridLayout(3,2));
        south.setLayout(new BorderLayout());

        center.add(jlb1);
        center.add(rate);
        center.add(jlb2);
        center.add(year);
        center.add(jlb3);
        center.add(amount);

        jta.setEditable(false);
        jta.setFont(new Font("",Font.BOLD,15));
        south.add(new JScrollPane(jta), BorderLayout.CENTER);
        south.add(jbt,BorderLayout.EAST);

        this.setLayout(new BorderLayout());
        this.add(center,BorderLayout.CENTER);
        this.add(south,BorderLayout.SOUTH);

        this.setTitle("Exercise31_1Client");
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        设计socket
        try{
            Socket socket = new Socket("localhost",8000);
            jbt.addActionListener(new MyActionListener(socket));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private class MyActionListener implements ActionListener{
        Socket socket = null;

        public MyActionListener(Socket socket){
            this.socket =socket;
        }

        @Override

        public void actionPerformed(ActionEvent arg0){
            try {
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                DataInputStream input = new DataInputStream(socket.getInputStream());
                double rateStr = Double.parseDouble(rate.getText().trim());
                double yearStr = Double.parseDouble(year.getText().trim());
                double amountStr = Double.parseDouble(amount.getText().trim());
                String message = rateStr+"@"+yearStr+"@"+amountStr;

                output.write(message.getBytes());
                output.flush();

                byte[] buf = new byte[1024];
                int len =0;

//                文本域清空
                rate.setText("");;
                year.setText("");
                amount.setText("");

                double amount = input.readDouble();
//                向jta中追加数据
                jta.append("rate: "+rateStr + ",year :"+yearStr+",amount:"+amountStr+",newAmount:"+amount);

            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new Client();
    }
}
