package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Text text = new Text( 0, 200,"Welcome to Java");

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(300), e -> {
            text.setX(text.getX() > pane.getWidth() - 10 ? 0 : text.getX() + 5);
        }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        FadeTransition ft = new FadeTransition(Duration.millis(3000), text);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Animation.INDEFINITE);
        ft.play();


        pane.getChildren().add(text);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
