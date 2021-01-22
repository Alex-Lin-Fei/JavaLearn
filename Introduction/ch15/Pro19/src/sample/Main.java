package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    Pane pane = new Pane();
    public static int count = 1;
    double start = System.currentTimeMillis();


    @Override
    public void start(Stage primaryStage) throws Exception{
        pane.setMinWidth(1000);
        pane.setMinHeight(1000);

        System.out.println(pane.getWidth() + " " + pane.getHeight());

        Circle circle = new Circle(Math.random() * pane.getWidth(),
                Math.random() * pane.getHeight(), 10);
        circle.setOnMouseClicked(event -> addCircle());
        Color color = Color.rgb((int)(Math.random() * 256), (int)(Math.random() * 256)
                , (int)(Math.random() * 256));
        circle.setFill(color);
        pane.getChildren().add(circle);


        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    public void addCircle() {
        count++;
        pane.getChildren().clear();
        if (count > 20) {
            System.out.println("Time spent is " + (System.currentTimeMillis() - start)
            + " milliseconds");
            System.exit(0);
        }

        Circle circle = new Circle(Math.random() * pane.getWidth(),
                Math.random() * pane.getHeight(), 10);
        circle.setOnMouseClicked(event -> addCircle());
        Color color = Color.rgb((int)(Math.random() * 256), (int)(Math.random() * 256)
                , (int)(Math.random() * 256));
        circle.setFill(color);
        pane.getChildren().add(circle);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
