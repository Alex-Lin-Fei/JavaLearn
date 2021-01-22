package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        pane.add(new Taichis(), 0, 0);
        pane.add(new Taichis(), 1, 1);
        pane.add(new Taichis(), 1, 0);
        pane.add(new Taichis(), 0, 1);
        primaryStage.setScene(new Scene(pane, 200, 200));
        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}

class Taichis extends Pane {
    public Taichis() {
        setWidth(200);
        setHeight(200);
        Circle circle = new Circle();
        circle.radiusProperty().bind(widthProperty().divide(2.2));
        circle.centerXProperty().bind(widthProperty().divide(2));
        circle.centerYProperty().bind(widthProperty().divide(2));
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Arc arc1 = new Arc(circle.getCenterX(), circle.getCenterY(),
                circle.getRadius() * 0.8, circle.getRadius() * 0.8, 0, 0.8 * circle.getRadius() * Math.PI / 6);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.RED);

        Arc arc2 = new Arc(circle.getCenterX(), circle.getCenterY(),
                circle.getRadius() * 0.8, circle.getRadius() * 0.8, 90, 0.8 * circle.getRadius() * Math.PI / 6);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.RED);

        Arc arc3 = new Arc(circle.getCenterX(), circle.getCenterY(),
                circle.getRadius() * 0.8, circle.getRadius() * 0.8, 180, 0.8 * circle.getRadius() * Math.PI / 6);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.RED);

        Arc arc4 = new Arc(circle.getCenterX(), circle.getCenterY(),
                circle.getRadius() * 0.8, circle.getRadius() * 0.8, 270, 0.8 * circle.getRadius() * Math.PI / 6);
        arc4.setType(ArcType.ROUND);
        arc4.setFill(Color.RED);

        getChildren().addAll(circle, arc1, arc2, arc3, arc4);
        setRotate(10);
    }
}
