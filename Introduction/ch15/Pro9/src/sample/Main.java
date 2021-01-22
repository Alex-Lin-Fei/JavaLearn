package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        final int[] startX = {100};
        final int[] startY = {100};

        pane.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case DOWN:{
                    Line line = new Line(startX[0], startY[0], startX[0], startY[0] + 10);
                    startY[0] += 10;
                    line.setStroke(Color.BLUE);
                    pane.getChildren().add(line);
                }
                break;
                case UP: {
                    Line line = new Line(startX[0], startY[0], startX[0], startY[0] - 10);
                    startY[0] -= 10;
                    line.setStroke(Color.BLUE);
                    pane.getChildren().add(line);
                }
                break;
                case LEFT: {
                    Line line = new Line(startX[0], startY[0], startX[0] - 10, startY[0]);
                    startX[0] -= 10;
                    line.setStroke(Color.BLUE);
                    pane.getChildren().add(line);
                }
                break;
                case RIGHT: {
                    Line line = new Line(startX[0], startY[0], startX[0] + 10, startY[0]);
                    startX[0] += 10;
                    line.setStroke(Color.BLUE);
                    pane.getChildren().add(line);
                }
                break;
            }
        });


        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
        pane.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
