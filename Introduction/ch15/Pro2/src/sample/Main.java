package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane pane = new StackPane();

        Text text = new Text(20, 50, "Programming is fun");
        text.setFill(Color.RED);
        pane.getChildren().add(text);

        EventHandler<ActionEvent> eventEventHandler = e-> {
            if (text.getText().length() != 0)
                text.setText(" ");
            else
                text.setText("Programming is fun");
        };

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(500), eventEventHandler)
        );
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        text.setOnMouseClicked(e->{
            if (animation.getStatus() == Animation.Status.PAUSED)
                animation.play();
            else
                animation.pause();
        });


        primaryStage.setScene(new Scene(pane, 250, 250));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
