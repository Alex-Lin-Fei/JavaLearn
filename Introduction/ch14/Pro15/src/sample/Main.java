package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new StackPane();

        Polygon octagon = new Polygon();
        octagon.setFill(Color.RED);
        octagon.setStroke(Color.RED);

        ObservableList<Double> list = octagon.getPoints();

        double start = 22.5;
        double radius = 200 * 0.4;
        double centerX = 200 / 2;
        double centerY = 200 / 2;
        for (int i = 0; i < 8; i++) {
            list.add(centerX + radius * Math.cos(start + i * Math.PI * 2 / 8));
            list.add(centerY - radius * Math.sin(start + i * Math.PI * 2 / 8));
        }

        Label label = new Label("STOP");
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Times New Roman", 40));
        pane.getChildren().addAll(octagon, label);

        pane.setMinWidth(200);
        pane.setMinHeight(200);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
