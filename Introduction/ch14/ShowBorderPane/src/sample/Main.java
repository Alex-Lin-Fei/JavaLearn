package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.text.DefaultEditorKit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane pane = new BorderPane();

        pane.setTop(new CustomPane("Top"));
        pane.setLeft(new CustomPane("Left"));
        pane.setBottom(new CustomPane("Bottom"));
        pane.setRight(new CustomPane("Right"));
        pane.setCenter(new CustomPane("Center"));

        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowBorderPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

class CustomPane extends StackPane {
    public CustomPane(String title) {
        this.getChildren().add(new Label(title));
        this.setStyle("-fx-border-color: red");
        setPadding(new Insets(12));
    }
}