package sample;

import com.sun.corba.se.impl.orbutil.ObjectUtility;
import com.sun.security.ntlm.Server;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Main extends Application {
    private TextArea ta = new TextArea();
    private int clientNo = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("MultiThreadServer");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                ta.appendText("MultiThreadServer started at  " + new Date() + "\n");
                while (true) {
                    Socket socket = serverSocket.accept();
                    clientNo++;
                    Platform.runLater(() -> {
                        ta.appendText("Starting thread for client " + clientNo + " at " +
                                new Date() + '\n');
                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client " + clientNo + "`s host name is " + inetAddress.getHostName() + '\n');
                        ta.appendText("Client " + clientNo + "`s IP Address " + inetAddress.getHostAddress());
                    });
                    new Thread(new HandleAClient(socket)).start();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    class HandleAClient implements Runnable {
        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream()
                );
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream()
                );

                while (true) {
                    double radius = inputFromClient.readDouble();
                    double area = radius * radius * Math.PI;
                    outputToClient.writeDouble(area);

                    Platform.runLater(() -> {
                        ta.appendText("radius received from client: " +
                                radius + "\n");
                        ta.appendText("Area found: " + area + '\n');
                    });
                }
            } catch (IOException ex) {
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
