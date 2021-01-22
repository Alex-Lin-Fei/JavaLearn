package sample;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server extends Application {
    private double radius;

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea ta = new TextArea();

        Scene scene = new Scene(new ScrollPane(ta), 450,200);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(()->{
            try{
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(()->{
                    ta.appendText("Server started at " + new Date() +"\n");

                    Socket socket = null;
                    try {
                        socket = serverSocket.accept();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    DataInputStream in = null;
                    DataOutputStream out = null;

                    try {
                        in = new DataInputStream(socket.getInputStream());
                        out = new DataOutputStream(socket.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    while (true) {
                        radius = 0;
                        try {
                            radius = in.readDouble();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        double area = radius * radius * Math.PI;

                        try {
                            out.writeDouble(area);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Platform.runLater(()->{
                            ta.appendText("Radius received from client: " + radius + "\n");
                            ta.appendText("Area is: " + area +"\n");
                        });
                    }
                });
            }catch (IOException e) {}
        }).start();
    }
}
