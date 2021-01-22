package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        RectanglePane rectanglePane = new RectanglePane();

        Button left = new Button("Left");
        left.setOnAction(e->rectanglePane.left());

        Button right = new Button("Right");
        right.setOnAction(e->rectanglePane.right());

        Button up = new Button("Up");
        up.setOnAction(e->rectanglePane.up());

        Button down = new Button("Down");
        down.setOnAction(e->rectanglePane.down());

        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(left, right, up, down);
        hBox.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setCenter(rectanglePane);
        pane.setBottom(hBox);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

class RectanglePane extends Pane {
    public Rectangle rectangle = new Rectangle(20, 20);
    public RectanglePane() {
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        getChildren().add(rectangle);
    }

    public void left() {
        rectangle.setX(rectangle.getX() > 0.5 ?
                rectangle.getX() - 0.5 : rectangle.getX());
    }

    public void right() {
        rectangle.setX(rectangle.getX() + 0.5);
    }

    public void up() {
        rectangle.setX(rectangle.getY() > 0.5 ?
                rectangle.getY() - 0.5 : rectangle.getY());
    }

    public void down() {
        rectangle.setY(rectangle.getY() + 0.5);
    }

}