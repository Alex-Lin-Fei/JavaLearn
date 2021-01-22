package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;

public class Server extends Application {
    private ScrollPane scrollPane;
    private TextArea textArea;
    private ServerSocket serverSocket;
    private HashMap<String, Socket> records = new HashMap<>();

    private int port=8000;

    public Server() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        textArea = new TextArea();
        scrollPane = new ScrollPane(textArea);

        new Thread(()-> {
            try {
                serverSocket = new ServerSocket(port);

                while (true) {
                    Socket socket = serverSocket.accept();
//                    显示连接到了哪个client
                    Platform.runLater(() -> {
                        InetAddress inetAddress = socket.getInetAddress();
                        textArea.appendText("Connection from Socket[addr = /" + inetAddress.getHostAddress() +
                                ", port=" +socket.getPort() + ", localtime =" + new Date() + '\n');
                    });
                    new Thread(new Handler(socket)).start();
                }

            } catch (IOException e) {
            }
        }).start();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(scrollPane, 300, 275));
        primaryStage.show();
    }

    class Handler implements Runnable{
        private Socket socket;
        private DataInputStream fromClient;
        private DataOutputStream toClient;

        Handler(Socket socket) throws IOException {
            this.socket = socket;
            fromClient = new DataInputStream(socket.getInputStream());
            toClient = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() {
            try {
//                通知client发送他自己的名字
                toClient.writeInt(1);
//                读取name存档
               String name = fromClient.readUTF();
               records.put(name, socket);
               Platform.runLater(()->{
                   textArea.appendText("The address " + socket.getInetAddress().getHostAddress() +
                                   "`s name is " + name+'\n');
               });

               while (true) {
//                   获取消息
                   String message = fromClient.readUTF();
//                   将消息以及发送者信息发送给所有人
                   records.forEach((key, value) -> {
                       try {
                           if (value != socket) {
                               DataOutputStream out = new DataOutputStream(value.getOutputStream());
                               out.writeUTF(name);
                               out.writeUTF(message);
                           }
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   });
               }
            }catch (IOException ignored){}
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
