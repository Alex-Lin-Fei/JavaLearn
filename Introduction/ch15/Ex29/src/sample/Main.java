package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;


public class Main extends Application {
    private int speed = 2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane pane = new BorderPane();
        CarPane car = new CarPane();

        pane.setCenter(car);

        car.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP)
                speed++;
            else if (event.getCode() == KeyCode.DOWN)
                speed--;
        });

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(40),event -> {
            car.x = car.x > pane.getWidth()-40? 0:car.x+speed;
            car.paintCar();
        }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();

        car.requestFocus();
    }

    class CarPane extends Pane {
        private Rectangle rectangle;
        private Circle wheel1, wheel2;
        private Polygon shed;
        public double x=0;
        private double y=50;

        CarPane() {
            paintCar();
        }

        public void paintCar() {
            getChildren().clear();

            rectangle = new Rectangle(x,y-20,50,10);
            wheel1 = new Circle(x+15,y-5,5);
            wheel2 = new Circle(x+35,y-5,5);
            shed = new Polygon();

            ObservableList<Double> list = shed.getPoints();
            list.add(x+10);
            list.add(y-20);
            list.add(x+20);
            list.add(y-30);
            list.add(x+30);
            list.add(y-30);
            list.add(x+40);
            list.add(y-20);

            rectangle.setFill(Color.BLUE);
            shed.setFill(Color.GRAY);
            getChildren().addAll(rectangle,wheel1,wheel2,shed);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
