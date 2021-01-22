package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Main extends Application {
    private int x = 100, y = 100;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        final int segment = 10;

        pane.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case UP:{
                    System.out.println(segment);
                    Line line = new Line(x, y, x,y - segment);
                    y -= segment;
                    pane.getChildren().add(line);
                }break;
                case DOWN:{
                    Line line = new Line(x, y, x,y + segment);
                    y += segment;
                    pane.getChildren().add(line);
                }break;
                case LEFT:{
                    Line line = new Line(x, y, x-segment,y);
                    x -= segment;
                    pane.getChildren().add(line);
                }break;
                case RIGHT:{
                    Line line = new Line(x, y, x+segment,y);
                    x += segment;
                    pane.getChildren().add(line);
                }break;
            }
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();

        pane.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
