package sample;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {


    public static void main(String[] args){
        Test frame = new Test();
        frame.setTitle("test");
        frame.setSize(200,100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}

class ArcsPanel extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        int xCen = getWidth()/2;
        int yCen = getHeight()/2;

        int radius = (int)(Math.min(getWidth(),getHeight() * 0.4));

        int x = xCen-radius;
        int y = yCen - radius;

        g.fillArc(x,y,2 * radius,2 * radius,0,30);

    }
}