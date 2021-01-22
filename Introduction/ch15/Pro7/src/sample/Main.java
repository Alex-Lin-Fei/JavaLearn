package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Circle circle = new Circle(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        Button change = new Button("Change");
        change.setOnMousePressed(e->
                circle.setFill(Color.RED));
        change.setOnMouseReleased(e->
                circle.setFill(Color.BLUE));

        BorderPane pane = new BorderPane();
        pane.setCenter(circle);
        pane.setBottom(change);
        BorderPane.setAlignment(change, Pos.CENTER);


        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
