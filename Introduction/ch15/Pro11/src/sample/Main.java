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
        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLUE);

        circle.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP: {
                    circle.setCenterY(circle.getCenterY() > 10 ?
                            circle.getCenterY() - 10 : circle.getCenterY());
                }break;
                case DOWN: {
                    circle.setCenterY(circle.getCenterY() + 10);
                }break;
                case LEFT:  {
                    circle.setCenterX(circle.getCenterX() > 10 ?
                            circle.getCenterX() - 10 : circle.getCenterX());
                }break;
                case RIGHT: {
                    circle.setCenterX(circle.getCenterX() + 10);
                }break;
            }
        });

        Pane pane = new Pane();
        pane.getChildren().add(circle);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
        circle.requestFocus();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
