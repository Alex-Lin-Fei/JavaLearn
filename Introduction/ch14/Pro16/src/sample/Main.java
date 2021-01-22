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

        Line line1 = new Line(0, 0, 0,0);
        line1.startXProperty().bind(pane.widthProperty().divide(3));
        line1.endXProperty().bind(pane.widthProperty().divide(3));
        line1.endYProperty().bind(pane.heightProperty());
        line1.setStroke(Color.RED);
        line1.setStrokeWidth(10);

        Line line2 = new Line(0, 0, 0, 0);
        line2.startXProperty().bind(pane.widthProperty().divide(3).multiply(2));
        line2.endXProperty().bind(pane.widthProperty().divide(3).multiply(2));
        line2.endYProperty().bind(pane.heightProperty());
        line2.setStroke(Color.RED);
        line2.setStrokeWidth(10);

        Line line3 = new Line(0, 0, 0, 0);
        line3.startYProperty().bind(pane.heightProperty().divide(3));
        line3.endXProperty().bind(pane.widthProperty());
        line3.endYProperty().bind(pane.heightProperty().divide(3));
        line3.setStroke(Color.BLUE);
        line3.setStrokeWidth(10);

        Line line4 = new Line(0, 0, 0,0 );
        line4.startYProperty().bind(pane.heightProperty().divide(3).multiply(2));
        line4.endXProperty().bind(pane.widthProperty());
        line4.endYProperty().bind(pane.heightProperty().divide(3).multiply(2));
        line4.setStroke(Color.BLUE);
        line4.setStrokeWidth(10);

        pane.getChildren().addAll(line1, line2, line3, line4);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
