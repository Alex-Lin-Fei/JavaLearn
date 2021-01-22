package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client2 extends Application {
    private TextField tfReceiver;
    private TextField tfMessage;
    private TextArea textArea;

    private Socket socket;
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    private int port = 8000;
    private String host = "localhost";

    private String name = "Fei";
    private String receiver = "john";

    @Override
    public void start(Stage primaryStage) throws Exception {
        tfReceiver = new TextField();
        tfMessage = new TextField();
        textArea = new TextArea();

        ScrollPane scrollPane = new ScrollPane(textArea);
        BorderPane pane = new BorderPane();
        GridPane gridPane = new GridPane();

        gridPane.add(new Label("Name"), 0, 0);
        gridPane.add(new Label("Enter text"), 0, 1);
        gridPane.add(tfReceiver, 1, 0);
        gridPane.add(tfMessage, 1, 1);

        pane.setCenter(gridPane);
        pane.setBottom(scrollPane);

        primaryStage.setTitle(name);
        primaryStage.setScene(new Scene(pane, 450, 350));
        primaryStage.show();

        tfMessage.setOnKeyPressed(event -> {
            try {
                if (event.getCode() == KeyCode.ENTER) {
                    String message = tfMessage.getText().trim();
                    toServer.writeUTF(message);
                    Platform.runLater(() -> {
                        textArea.appendText(name + ": " + message+"\n");
                    });
                }
            } catch (IOException ignored) {
            }
        });

        new Thread(() -> {
            try {
//            建立连接
                socket = new Socket(host, port);

                fromServer = new DataInputStream(socket.getInputStream());
                toServer = new DataOutputStream(socket.getOutputStream());

//                得到通知发送自己的名字
                fromServer.readInt();
                toServer.writeUTF(name);

                while (true) {
                    //                    接收消息发送方
                    String sender = fromServer.readUTF();
//                    发送消息 接收消息
                    String message = fromServer.readUTF();
                    Platform.runLater(() -> {
                        textArea.appendText(sender + ": " + message + '\n');
                    });
                }
            } catch (IOException ignored) {
            }
        }).start();
    }
}
