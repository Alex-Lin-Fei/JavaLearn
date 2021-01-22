package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {
    private TextField tfRate = new TextField();
    private TextField tfYear = new TextField();
    private TextField tfAmount = new TextField();
    private Button btSubmit = new Button("submit");
    private TextArea ta;

    private String host = "localhost";
    private int port = 8000;
    private Socket socket;
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ta = new TextArea();

        ScrollPane sp = new ScrollPane(ta);
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Annual Interest Rate"),0,0);
        gridPane.add(tfRate,1,0);
        gridPane.add(new Label("Number of Years"),0,1);
        gridPane.add(tfYear, 1,1);
        gridPane.add(new Label("Loan Amount"), 0,2);
        gridPane.add(tfAmount, 1,2);
        gridPane.add(btSubmit,2,1);

        BorderPane pane = new BorderPane();
        pane.setCenter(gridPane);
        pane.setBottom(sp);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

        btSubmit.setOnAction(e->{
            try {
                handler();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        new Thread(()->{
            try {
                socket = new Socket(host, port);
                fromServer = new DataInputStream(socket.getInputStream());
                toServer = new DataOutputStream(socket.getOutputStream());

                Platform.runLater(()->{
                    ta.appendText("Connect to host " + host);
                });

                while (true) {
//                    接收结果
                    double monthlyPayment = fromServer.readDouble();
                    double totalPayment = fromServer.readDouble();

//                    显示
                    Platform.runLater(()->{
                        ta.appendText("monthlyPayment: " + monthlyPayment+'\n');
                        ta.appendText("totalPayment: " + totalPayment+'\n');
                    });
                }
            }catch (IOException e) {

            }
        }).start();



    }

    public void handler() throws IOException {
        double rate = Double.parseDouble(tfRate.getText());
        double year = Double.parseDouble(tfYear.getText());
        double amount =  Double.parseDouble(tfAmount.getText());

//                    发送给服务器
        toServer.writeDouble(rate);
        toServer.writeDouble(year);
        toServer.writeDouble(amount);


//                    显示
        Platform.runLater(()->{
            ta.appendText("Annual Interest Rate: " + rate+'\n');
            ta.appendText("Number of Year: " + year+'\n');
            ta.appendText("Loan Amount: " + amount+'\n');
        });
    }
}
