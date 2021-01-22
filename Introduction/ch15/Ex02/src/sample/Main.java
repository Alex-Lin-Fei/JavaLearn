package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.util.concurrent.BrokenBarrierException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane pane = new BorderPane();
        Ellipse ellipse = new Ellipse(100,100,80,40);
        Button rotate = new Button("Rotate");

        ellipse.setFill(Color.YELLOW);
        pane.setCenter(ellipse);
        pane.setBottom(rotate);
        BorderPane.setAlignment(rotate, Pos.CENTER);
        rotate.setOnAction(e->{
            ellipse.setRotate(80);
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
