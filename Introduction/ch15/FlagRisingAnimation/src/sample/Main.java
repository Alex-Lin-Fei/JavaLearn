package sample;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        ImageView imageView = new ImageView("file:D:\\algorithm\\JavaCode\\Introduction\\image\\china.jpg");
        pane.getChildren().add(imageView);

        PathTransition pt = new PathTransition(Duration.millis(10000),
                new Line(10, 200, 100, 0),imageView);
        pt.setCycleCount(5);
        pt.play();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
