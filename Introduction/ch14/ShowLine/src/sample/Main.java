package sample;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(new LinePane(), 300, 275));
        primaryStage.show();
    }

    class LinePane extends Pane {
        public LinePane() {
            Line line1 = new Line(10, 10, 10, 10);
            line1.endXProperty().bind(widthProperty().subtract(10));
            line1.endYProperty().bind(heightProperty().subtract(10));
            line1.setStrokeWidth(5);
            line1.setStroke(Color.GRAY);
            this.getChildren().add(line1);
            Line line2 = new Line(10, 10, 10, 10);
            line2.startXProperty().bind(widthProperty().subtract(10));
            line2.endYProperty().bind(heightProperty().subtract(10));
            line2.setStrokeWidth(5);
            line2.setStroke(Color.GREEN);
            getChildren().add(line2);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
