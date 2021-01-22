package sample;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javax.print.DocFlavor;
import java.util.Collection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        int width = 40;
        int height = 40;

        int color = 1;
        for (int i = 0; i < 10; i++) {
            color = 1-color;
            for (int j = 0; j < 10; j++) {
                Rectangle rectangle = new Rectangle(i * height, j * width, width, height);
                if (color == 0)
                    rectangle.setFill(Color.WHITE);
                else
                    rectangle.setFill(Color.BLACK);
                color = 1 - color;
                pane.add(rectangle, j, i);
            }
        }


        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
