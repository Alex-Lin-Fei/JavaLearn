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
        Circle circle = new Circle(120, 120,100);

        pane.getChildren().add(circle);
        circle.setFill(Color.BLUE);

        circle.setOnMousePressed(e->{
            circle.setFill(Color.RED);
        });

        circle.setOnMouseReleased(e->{
            circle.setFill(Color.BLUE);
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
