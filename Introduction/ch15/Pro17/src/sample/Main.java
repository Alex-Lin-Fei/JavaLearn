package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicReference;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLUE);

        PriorityQueue<Double> u = new PriorityQueue<>();
        u.add(10000.);
        AtomicReference<Double> d = new AtomicReference<>((double) 0);
        AtomicReference<Double> l = new AtomicReference<>((double) 10000);
        AtomicReference<Double> r = new AtomicReference<>((double) 0);


        Pane pane = new Pane();
        pane.getChildren().add(rectangle);
        pane.setOnMousePressed(event -> {
            if(event.isPrimaryButtonDown()) {
                u.set(Math.min(event.getY() - 5, u.get()));
                d.set(Math.max(event.getY() + 5, d.get()));
                l.set(Math.min(event.getX() - 5, l.get()));
                r.set(Math.max(event.getX() + 5, r.get()));

                Circle circle = new Circle(event.getX(), event.getY(), 10);
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLUE);
                circle.setOnMousePressed(event1 -> {
                    if (event1.isSecondaryButtonDown())
                        pane.getChildren().remove(circle);
                });
                pane.getChildren().add(circle);
                rectangle.setX(l.get());
                rectangle.setY(u.get());
                rectangle.setWidth(r.get() - l.get());
                rectangle.setHeight(d.get() - u.get());
            }
        });

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
