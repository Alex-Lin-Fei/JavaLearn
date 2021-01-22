package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Polyline polyline = new Polyline();

        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor = 0.125;

        for (int x = -10; x <= 10; x += scaleFactor) {
            list.add((double)(x));
            list.add((double) (x * x));
        }
        Pane pane = new Pane();
        pane.getChildren().add(polyline);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
