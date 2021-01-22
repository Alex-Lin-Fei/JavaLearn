package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();
        Button btOK = new Button("ok");
        btOK.setStyle("-fx-border-color: blue;");
        pane.getChildren().add(btOK);

        pane.setRotate(45);
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("NodeStyleRotateDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
