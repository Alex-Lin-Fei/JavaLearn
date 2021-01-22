package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Rectangle rectangle = new Rectangle(80, 50, 100, 30);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);

        Pane pane = new Pane();
        pane.getChildren().add(rectangle);

        pane.setOnMouseMoved(event -> {
            pane.getChildren().clear();
            pane.getChildren().add(rectangle);
            double x = event.getX();
            double y = event.getY();

            String str = "Mouse point is ";
            if (x >= 80 && x <= 80 + 100 && y >= 50 && y <= 50 + 30)
                str += "inside ";
            else
                str += "outside ";
            str += "the rectangle";
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
