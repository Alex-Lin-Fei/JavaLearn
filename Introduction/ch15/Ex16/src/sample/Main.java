package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.Callable;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        Circle c1 = new Circle(40,40,10);
        Circle c2 = new Circle(120,150,10);
        Line line = new Line(40,40,120,150);
        Text text = new Text();
        text.setX((c1.getCenterX() + c2.getCenterX())/2);
        text.setY((c1.getCenterY() + c2.getCenterY())/2);
        text.setText(String.valueOf(Math.sqrt(Math.pow(c1.getCenterX() - c2.getCenterX(),2)+Math.pow(c1.getCenterY() - c2.getCenterY(),2))));

        c1.setStroke(Color.BLACK);
        c1.setFill(Color.WHITE);
        c2.setStroke(Color.BLACK);
        c2.setFill(Color.WHITE);

        pane.getChildren().addAll( line,c1,c2,text);

        c1.setOnMouseDragged(event -> {
            c1.setCenterX(event.getX());
            c1.setCenterY(event.getY());
            line.setStartX(event.getX());
            line.setStartY(event.getY());
            text.setX((c1.getCenterX() + c2.getCenterX())/2);
            text.setY((c1.getCenterY() + c2.getCenterY())/2);
            text.setText(String.valueOf(Math.sqrt(Math.pow(c1.getCenterX() - c2.getCenterX(),2)+Math.pow(c1.getCenterY() - c2.getCenterY(),2))));
        });

        c2.setOnMouseDragged(event -> {
            c2.setCenterX(event.getX());
            c2.setCenterY(event.getY());
            line.setEndX(event.getX());
            line.setEndY(event.getY());
            text.setX((c1.getCenterX() + c2.getCenterX())/2);
            text.setY((c1.getCenterY() + c2.getCenterY())/2);
            text.setText(String.valueOf(Math.sqrt(Math.pow(c1.getCenterX() - c2.getCenterX(),2)+Math.pow(c1.getCenterY() - c2.getCenterY(),2))));
        });







        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
