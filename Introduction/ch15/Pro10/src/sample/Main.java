package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        pane.setOnKeyPressed(event -> {
            StringBuilder str = null;
            while (!event.getText().equals("\n")) {
                str.append(event.getCharacter());
            }


            assert str != null;
            pane.getChildren().add(new Text(str.toString()));
        });


        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
        pane.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
