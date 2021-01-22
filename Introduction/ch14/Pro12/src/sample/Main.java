package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.time.temporal.Temporal;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        int height = 300;
        int paneHeight = 150;

        Rectangle rectangle1 = new Rectangle(10, (int)(paneHeight - height * 0.2), 100, (int)(height * 0.2));
        rectangle1.setFill(Color.RED);
        rectangle1.setStroke(Color.RED);
        Text text1 = new Text(10, (int)(paneHeight - height * 0.2) - 10, "Apple -- 20%");

        Rectangle rectangle2 = new Rectangle(10 + 110, (int)(paneHeight - height * 0.26), 100, (int)(height * 0.26));
        rectangle2.setFill(Color.BLUE);
        rectangle2.setStroke(Color.BLUE);
        Text text2 = new Text(10 + 110, (int)(paneHeight - height * 0.26) - 10, "HTC -- 26%");

        Rectangle rectangle3 = new Rectangle(10 + 220, (int)(paneHeight - height * 0.28), 100, (int)(height * 0.28));
        rectangle3.setFill(Color.GREEN);
        rectangle3.setStroke(Color.GREEN);
        Text text3 = new Text(10 + 220, (int)(paneHeight - height * 0.28) - 10, "Samsung -- 28%");

        Rectangle rectangle4 = new Rectangle(10 + 330, (int)(paneHeight - height * 0.26), 100, (int)(height * 0.26));
        rectangle4.setFill(Color.ORANGE);
        rectangle4.setStroke(Color.ORANGE);
        Text text4 = new Text(10 + 330, (int)(paneHeight - height * 0.26) - 10, "others -- 26%");

        pane.getChildren().addAll(rectangle1, rectangle2, rectangle3, rectangle4, text1, text2, text3, text4);

        primaryStage.setScene(new Scene(pane, 150, 150));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
