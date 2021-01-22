package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    private String show;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();
        Circle circle = new Circle(100,60,50);

        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);

        pane.setOnMouseMoved(event -> {
            pane.getChildren().clear();
            double dist = Math.sqrt(Math.pow(event.getX() - circle.getCenterX(),2)+
                    Math.pow(event.getY() - circle.getCenterY(),2));
            if (dist < circle.getRadius())
                show = "Mouse point is inside the circle";
            else
                show = "Mouse point is outside the circle";
            Text text = new Text( event.getX(), event.getY(),show);
            pane.getChildren().add(circle);
            pane.getChildren().add(text);
        });


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
