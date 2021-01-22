package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BallPane ballPane = new BallPane();

        ballPane.setOnMousePressed(e->ballPane.pause());
        ballPane.setOnMouseReleased(e->ballPane.play());

        ballPane.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.UP)
                ballPane.increaseSpeed();
            else if (e.getCode() == KeyCode.DOWN)
                ballPane.decreaseSpeed();
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(ballPane, 300, 275));
        primaryStage.show();

        ballPane.requestFocus();
    }



    class BallPane extends Pane {
        private final double radius = 20;
        private double x=radius;
        private double y=radius;
        private double dx=1;
        private double dy=1;
        private Circle circle = new Circle(x, y, radius);
        private Timeline animation;


        BallPane() {
            getChildren().add(circle);
            circle.setFill(Color.BLUE);
            animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }

        public void play() {
            animation.play();
        }

        public void pause() {
            animation.pause();
        }

        public void increaseSpeed() {
            animation.setRate(animation.getRate()+0.1);
        }

        public void decreaseSpeed() {
            animation.setRate(animation.getRate() > 0.1 ? animation.getRate() - 0.1 : animation.getRate());
        }

        public void moveBall() {
            if (x < radius || x > getWidth() - radius)
                dx *= -1;
            if (y < radius || y > getHeight() - radius)
                dy *= -1;
            x += dx;
            y += dy;
            circle.setCenterX(x);
            circle.setCenterY(y);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
