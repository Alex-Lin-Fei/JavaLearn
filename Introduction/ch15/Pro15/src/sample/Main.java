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

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        pane.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown()) {
                Circle circle = new Circle(event.getX(), event.getY(), 10);
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLUE);
                circle.setOnMouseDragged(event1 -> {
                    if (event1.isSecondaryButtonDown()) {
                        circle.setCenterX(event1.getX());
                        circle.setCenterY(event1.getY());
                    }
                });
                pane.getChildren().add(circle);
            }
        });

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
