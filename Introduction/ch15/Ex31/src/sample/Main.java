package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private double speed = 0.01;
    private double angle;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        Circle c1= new Circle(150,40,5);
        Circle c2 = new Circle(50,250,10);
        Line line = new Line(150,40,50,250);
        pane.getChildren().addAll(c1,c2,line);

        double radius = Math.sqrt(Math.pow(100,2) + Math.pow(210,2));


       double startAngle = Math.PI + Math.atan(210/100.0);
       angle = startAngle;
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(30),event -> {
            angle += speed;
            if (angle >= 3 * Math.PI - startAngle || angle <= startAngle)
                speed *= -1;

            line.setEndX(c1.getCenterX()+radius*Math.cos(angle));
            line.setEndY(c1.getCenterY()-radius*Math.sin(angle));
            c2.setCenterX(line.getEndX());
            c2.setCenterY(line.getEndY());
        }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        pane.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    speed *= 1.2;
                    break;
                case DOWN:
                    speed *= 0.8;
                    break;
                case S:
                    animation.pause();
                    break;
                case R:
                    animation.play();
                    break;
            }
        });


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
        pane.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
