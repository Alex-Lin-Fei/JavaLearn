package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        pane.setOnMousePressed(event ->{
            double x = event.getSceneX();
            double y = event.getSceneY();
            Text text = new Text((int)x, (int)y, "(" + x + ", " + y + ")");
            pane.getChildren().add(text);
                }
                );
        pane.setOnMouseReleased(event -> {
            pane.getChildren().clear();
        });

        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
