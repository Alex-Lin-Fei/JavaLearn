package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();
        String str = "Welcome to JavaFX";
        double centerX = 400 * 0.5;
        double centerY = 400 * 0.5;
        double radius = 400 * 0.4;
        for (int i = 0; i < str.length(); i++) {
            double x = centerX + radius * Math.cos(Math.PI * i * 2 / str.length());
            double y = centerY - radius * Math.sin(Math.PI * i * 2 / str.length());
            Text text = new Text(x, y, String.valueOf(str.charAt(i)));
            text.setFill(Color.RED);
            text.setRotate(Math.PI * i * 2 / str.length());
            pane.getChildren().add(text);
            pane.setRotate(Math.PI * i * 2 / str.length());
        }

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
