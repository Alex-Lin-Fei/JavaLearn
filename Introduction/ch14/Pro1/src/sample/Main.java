package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       GridPane pane = new GridPane();
       File england = new File("image/uk.bmp");
       Image imageEngland = new Image(england.toURI().toString());
       pane.add(new ImageView(imageEngland), 0, 0);

        File canada = new File("image/canada.bmp");
        Image imageCanada = new Image(canada.toURI().toString());
        pane.add(new ImageView(imageCanada), 1, 0);

        File china = new File("image/china.jpg");
        Image imageChina = new Image(china.toURI().toString());
        pane.add(new ImageView(imageChina), 0, 1);

        File america = new File("image/us.jpg");
        Image imageAmerica = new Image(america.toURI().toString());
        pane.add(new ImageView(imageAmerica), 1, 1);


        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowImage");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
