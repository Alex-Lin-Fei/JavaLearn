package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane pane = new StackPane();
        Text text1 = new Text("Java is fun");
        Text text2 = new Text("Java is powerful");
        pane.getChildren().addAll(text1);

        pane.setOnMouseClicked(
                event -> {
                    if (pane.getChildren().contains(text1)) {
                        pane.getChildren().add(text2);
                        pane.getChildren().remove(text1);
                    }
                    else {
                        pane.getChildren().add(text1);
                        pane.getChildren().remove(text2);
                    }

                }
        );
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
