package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Rectangle rectangle = new Rectangle(100, 100, 60, 30);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLUE);

        rectangle.setOnMouseDragged(event -> {
            rectangle.setX(event.getX() - 30);
            rectangle.setY(event.getY() - 15);
        });

        Pane pane = new Pane();
        pane.getChildren().add(rectangle);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
