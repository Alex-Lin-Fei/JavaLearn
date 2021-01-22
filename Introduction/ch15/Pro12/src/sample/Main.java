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

    @Override
    public void start(Stage primaryStage) throws Exception{
        Circle circle = new Circle(100, 60, 50);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.WHITE);
        Pane pane = new Pane();
        pane.getChildren().add(circle);

        pane.setOnMouseMoved(event -> {
            pane.getChildren().clear();
            pane.getChildren().add(circle);
            double x = event.getX();
            double y = event.getY();
            String str = "Mouse point is ";
            if(!(Math.sqrt(Math.pow(x - 100, 2) + Math.pow(y - 60, 2)) > 50))
                str += "inside ";
            else
                str += "outside ";
            str += "the circle";
            Text text = new Text(x, y, str);
            pane.getChildren().add(text);
        });

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
        pane.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
