package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        double width = 400;
        double height = 350;

        Circle circle1 = new Circle(Math.random() * width,
                Math.random() * height, 10);
        Circle circle2 = new Circle(Math.random() * width,
                Math.random() * height, 10);

        Circle circle3 = new Circle(Math.random() * width,
                Math.random() * height, 10);

        circle1.setFill(Color.BLUE);
        circle2.setFill(Color.BLUE);
        circle3.setFill(Color.BLUE);

        circle1.setOnMouseDragged(event -> {
            circle1.setCenterX(event.getX());
            circle1.setCenterY(event.getY());
        });

        circle2.setOnMouseDragged(event -> {
            circle2.setCenterX(event.getX());
            circle2.setCenterY(event.getY());
        });

        circle3.setOnMouseDragged(event -> {
            circle3.setCenterX(event.getX());
            circle3.setCenterY(event.getY());
        });

        Line line1 = new Line(circle1.getCenterX(), circle1.getCenterY(),
                circle2.getCenterX(), circle2.getCenterY());
        line1.startXProperty().addListener(ov->line1.setStartX(circle1.getCenterX()));
        line1.startYProperty().addListener(ov->line1.setStartY(circle1.getCenterY()));
        line1.endXProperty().addListener(ov->line1.setEndX(circle2.getCenterX()));
        line1.endYProperty().addListener(ov->line1.setEndY(circle2.getCenterY()));


        Line line2 = new Line(circle2.getCenterX(), circle2.getCenterY(),
                circle3.getCenterX(), circle3.getCenterY());
        line2.startXProperty().addListener(ov->{
            line2.setStartX(circle2.getCenterX());
            line2.setStartY(circle2.getCenterY());
            line2.setEndX(circle3.getCenterX());
            line2.setEndY(circle3.getCenterY());
        });

        Line line3 = new Line(circle3.getCenterX(), circle3.getCenterY(),
                circle1.getCenterX(), circle1.getCenterY());

        line1.setStroke(Color.BLACK);
        line2.setStroke(Color.BLACK);
        line3.setStroke(Color.BLACK);

        pane.getChildren().addAll(circle1, circle2, circle3, line1, line2, line3);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
