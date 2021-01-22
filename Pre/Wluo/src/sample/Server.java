package sample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.util.Date;

public class Server {
    public void start(Stage primaryStage){
        TextArea ta = new TextArea();
        Scene scene = new Scene(new ScrollPane(ta),450,200);
        primaryStage.setTitle("server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(()->{
            try {
                ServerSocket serversocket = new ServerSocket(8000);
                Platform.runLater(()->
                        ta.appendText("server started at "+ new Date()+"\n"));
                Socket socket = serversocket.accept();

                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while(true){
                    double radius = inputFromClient.readDouble();
                    double area = Math.PI * radius * radius;
                    outputToClient.writeDouble(area);

                    Platform.runLater(()->{
                        ta.appendText("radius receive from client :"+radius+"\n");
                        ta.appendText("area is:"+area+"\n");
                            }
                            );
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }).start();
    }
}
