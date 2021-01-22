package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client extends Application {
    private Socket socket;
    private DataOutputStream toServer;
    private DataInputStream fromServer;

    private TextArea messageTa = new TextArea();
    private TextArea inputTa = new TextArea();
    private ScrollPane messagePane;
    private ScrollPane inputPane;

    private int port = 8000;
    private String host = "localhost";


    @Override
    public void start(Stage primaryStage) throws Exception {
//        初始化UI界面
        messagePane = new ScrollPane(messageTa);
        inputPane = new ScrollPane(inputTa);

        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(new Label("Server"), messagePane, new Label("Client"), inputPane);
        messageTa.setEditable(false);

        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(vBox, 300, 275));
        primaryStage.show();

        inputTa.requestFocus();

        inputTa.setOnKeyPressed(event -> {
            try {
                if (event.getCode() == KeyCode.ENTER) {
                    String message = inputTa.getText().trim();
                    toServer.writeUTF(message);
                    messageTa.appendText("client: " + message + '\n');
                    inputTa.clear();
                }
            }catch (IOException e){}
        });


        new Thread(()->{
            try {
                socket = new Socket(host, port);
                fromServer = new DataInputStream(socket.getInputStream());
                toServer = new DataOutputStream(socket.getOutputStream());
                messageTa.appendText("Connect to " + host + '\n');

                while (true){
                    String message = fromServer.readUTF();
                    Platform.runLater(()->{
                        messageTa.appendText("server: " + message + '\n');
                    });
//                    toServer.writeUTF("world");
                }

            }catch (IOException e){}
        }).start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
