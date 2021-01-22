package sample;

import sun.nio.cs.HistoricallyNamedCharset;

import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

public class HandleEvent extends JFrame {
   public HandleEvent() {
       JButton jButton1 = new JButton("OK");
       JButton jButton2 = new JButton("cancel");

       JPanel panel = new JPanel();
       panel.add(jButton1);
       panel.add(jButton2);
       add(panel);

       OKListener ok = new OKListener();
       CancleListener cancel = new CancleListener();

       jButton1.addActionListener(ok);
       jButton2.addActionListener(cancel);
   }

   public static void main(String[] args) {
       JFrame frame = new HandleEvent();
       frame.setTitle("handle event");
       frame.setSize(200,150);
       frame.setLocation(200,100);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
   }
}

class OKListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("ok button clicked");
    }
}

class CancleListener implements ActionListener {
    public void actionPerformed (ActionEvent e) {
        System.out.println("cancel button clicked");
    }
}
