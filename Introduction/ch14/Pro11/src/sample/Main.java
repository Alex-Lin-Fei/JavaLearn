package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        Circle circle = new Circle(100, 100, 80);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        Circle circle1 = new Circle(70, 70, 10);
        Circle circle2 = new Circle(130, 70, 10);
        circle1.setFill(Color.BLACK);
        circle1.setStroke(Color.BLACK);
        circle2.setFill(Color.BLACK);
        circle2.setStroke(Color.BLACK);

        Ellipse ellipse1 = new Ellipse(70, 70, 20, 15);
        Ellipse ellipse2 = new Ellipse(130, 70, 20, 15);
        ellipse1.setFill(Color.WHITE);
        ellipse1.setStroke(Color.BLACK);
        ellipse2.setFill(Color.WHITE);
        ellipse2.setStroke(Color.BLACK);

        Line line1 = new Line(100, 80, 125, 125);
        Line line2 = new Line(125, 125, 80, 125);

        Arc arc = new Arc(100, 130, 50, 15, 180, 180);
        arc.setStroke(Color.BLACK);
        arc.setFill(Color.WHITE);


        pane.getChildren().addAll(circle, ellipse1, ellipse2, circle1, circle2, arc, line1, line2);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();





        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
