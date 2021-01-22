package sample;

import com.sun.deploy.xml.XMLable;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

public class Server extends Application {
    private ServerSocket serverSocket;
    private DataOutputStream toClient;
    private DataInputStream fromClient;

    private TextArea messageTa;
    private TextArea inputTa;
    private TextField inputTf;
    private ScrollPane messagePane;
    private ScrollPane inputPane;
    private Button btSubmit;


    private int port = 8000;
    private boolean waiting = true;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        初始化UI界面
        messageTa = new TextArea();
        inputTa = new TextArea();

        inputTf = new TextField();
        btSubmit = new Button("submit");

        messagePane = new ScrollPane(messageTa);
        inputPane = new ScrollPane(inputTa);

        VBox vBox = new VBox(5);
//        vBox.getChildren().addAll(new Label("Server"), messagePane, new Label("Client"), inputTf, btSubmit);
        vBox.getChildren().addAll(new Label("Server"), messagePane, new Label("Client"), inputPane);
        messageTa.setEditable(false);


        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(vBox, 300, 275));
        primaryStage.show();

        inputTa.requestFocus();

        inputTa.setOnKeyPressed(event -> {
            try {
                if (event.getCode() == KeyCode.ENTER) {
                    String message = inputTa.getText().trim();
                    toClient.writeUTF(message);
                    messageTa.appendText("server: " + message + '\n');
                    inputTa.clear();
                    waiting = false;
                }
            }catch (IOException e){}
        });

//        btSubmit.setOnAction(event -> {
//            try {
//                String message = inputTf.getText();
//                toClient.writeUTF(message);
        
//                messageTa.appendText("send: " + message+'\n');
//            }catch (IOException e){}
//        });

        new Thread(()->{
            try {
                serverSocket = new ServerSocket(port);
                Socket socket = serverSocket.accept();

                fromClient = new DataInputStream(socket.getInputStream());
                toClient = new DataOutputStream(socket.getOutputStream());

        while (true){
                    String message = fromClient.readUTF();
                    Platform.runLater(()->{
                        messageTa.appendText("client: " + message + '\n');
                    });
                }
            }catch (IOException ex) {}
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
