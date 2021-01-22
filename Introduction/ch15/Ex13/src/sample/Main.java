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
    private Text text = new Text();
    private String show;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(30,35,100,30);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);


        pane.getChildren().add(rectangle);
        pane.getChildren().add(text);

        pane.setOnMouseMoved(event -> {
            text.setX(event.getX());
            text.setY(event.getY());
            if (event.getX() >= rectangle.getX() && event.getY() >= rectangle.getY() &&
            event.getX() <= rectangle.getX()+rectangle.getWidth() && event.getY() <= rectangle.getY()+rectangle.getHeight()){
                text.setText("Mouse point is inside the rectangle");
            }
            else
                text.setText("Mouse point is outside the rectangle");
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
