package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sun.nio.cs.ext.MacHebrew;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server extends Application {
    TextArea ta = new TextArea();
    private ServerSocket serverSocket;
    private Socket socket;

    private int clientNo = 1;

    private int port = 8000;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("Exercise_01");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                Platform.runLater(() -> {
                    ta.appendText("Exercise33_01 started at " + new Date() + '\n');
                });
                while (true) {
                    socket = serverSocket.accept();

                    clientNo++;
                    Platform.runLater(() -> {
                        ta.appendText("Starting thread for client " + clientNo + " at " + new Date() + "\n");
                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client " + clientNo + "`s host name is " +
                                inetAddress.getHostName() + '\n');
                        ta.appendText("Client " + clientNo + "`s IP address is " +
                                inetAddress.getHostAddress() + '\n');
                    });
                    new Thread(new Handler()).start();
                }
            } catch (IOException ignored) {
            }


        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class Handler implements Runnable {

        @Override
        public void run() {
            try {
                DataInputStream fromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    double rate = fromClient.readDouble();
                    double year = fromClient.readDouble();
                    double amount = fromClient.readDouble();

                    double monthlyInterestRate = rate / 1200;
                    double monthlyPayment = amount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, year * 12)));
                    double totalPayment = year * 12 * monthlyPayment;

                    Platform.runLater(() -> {
                        ta.appendText("Annual Interest Rate: " + rate + '\n');
                        ta.appendText("Number of Year: " + year + '\n');
                        ta.appendText("Loan Amount: " + amount + '\n');
                        ta.appendText("monthlyPayment: " + monthlyPayment + '\n');
                        ta.appendText("totalPayment: " + totalPayment + '\n');
                    });


                    toClient.writeDouble(monthlyPayment);
                    toClient.writeDouble(totalPayment);
                }
            } catch (IOException e) {
            }
        }
    }
}
