package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSResourceResolver;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane pane = new BorderPane();
        HBox hBox = new HBox(5);
        Button left = new Button("Left");
        Button right = new Button("Right");
        Button up = new Button("Up");
        Button down = new Button("Down");
        Rectangle rectangle = new Rectangle(50,50,130,70);



        rectangle.setFill(Color.GRAY);
        hBox.getChildren().addAll(left, right, up, down);;
        pane.getChildren().add(rectangle);
        pane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

//        定义事件句柄
        left.setOnAction(e-> {
            rectangle.setX(rectangle.getX() > 5 ? rectangle.getX() - 5 : rectangle.getX());
        });

        right.setOnAction(e->{
            rectangle.setX(rectangle.getX()>pane.getWidth()? rectangle.getX(): rectangle.getX()+5);
        });

        up.setOnAction(e->{
            rectangle.setY(rectangle.getY() > 5 ? rectangle.getY() - 5 : rectangle.getY());
        });

        down.setOnAction(e->{
            rectangle.setY(rectangle.getY()>pane.getHeight()? rectangle.getY(): rectangle.getY()+5);
        });





        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
