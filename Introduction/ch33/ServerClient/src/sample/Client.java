package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Locale;

public class Client extends Application {
    DataInputStream fromServer = null;
    DataOutputStream toServer = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        pane.setStyle("-fx-border-color: green");
        pane.setLeft(new Label("Enter a radius:"));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        pane.setCenter(tf);

        BorderPane mainPane = new BorderPane();
        TextArea ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(pane);

        Scene scene = new Scene(mainPane, 450,200);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        tf.setOnAction(e->{
            try {
                double radius = Double.parseDouble(tf.getText().trim());
                toServer.writeDouble(radius);
                toServer.flush();

                double area = fromServer.readDouble();
                ta.appendText("Radius is " + radius +'\n');
                ta.appendText("Area received from the server is " + area + "\n");

            }catch (IOException ex) {

            }

        });

        try {
            Socket socket = new Socket("localhost", 8000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());

        }catch (IOException e) {

        }

    }
}
