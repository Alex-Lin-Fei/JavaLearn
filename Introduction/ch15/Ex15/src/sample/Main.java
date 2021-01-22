package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.crypto.Cipher;

public class Main extends Application {
    private int radius = 6;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        pane.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY)
            {
//                添加一个⚪
                Circle circle = new Circle(event.getX(), event.getY(), radius);
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLACK);
                circle.setOnMouseClicked(e->{
                    if (event.getButton() == MouseButton.PRIMARY) {
                        System.out.println("e");
                        pane.getChildren().remove(circle);
                    }
                });

                pane.getChildren().add(circle);
            }
        });


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
