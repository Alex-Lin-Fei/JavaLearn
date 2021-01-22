package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        pane.setOnMousePressed(e -> {
            pane.getChildren().clear();
            Text text = new Text(e.getX(), e.getY(), "(" + e.getX() + ", " + e.getY() + ")");
            pane.getChildren().add(text);
        });

        pane.setOnMouseReleased(e->{
            pane.getChildren().clear();
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
