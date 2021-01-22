package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

//        for (int radius = 100; radius >= 0; radius -= 10) {
//            Circle circle = new Circle(100, 100, radius);
//            circle.setFill(Color.WHITE);
//            circle.setStroke(Color.RED);
//            pane.getChildren().add(circle);
//        }
        drawCircle(pane, 100);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void drawCircle(Pane pane, int radius) {
        if (radius > 10) {
            Circle circle = new Circle(100, 100, radius);
            circle.setStroke(Color.RED);
            circle.setFill(Color.WHITE);
            pane.getChildren().add(circle);
            drawCircle(pane, radius - 10);
        }
    }
}
