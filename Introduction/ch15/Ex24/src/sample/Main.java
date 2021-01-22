package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.table.TableRowSorter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        Circle circle = new Circle(10);

        Arc arc = new Arc(150,100,80,80,230, 80);

        pane.getChildren().addAll(arc, circle);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(arc);
        pt.setCycleCount(Animation.INDEFINITE);
        pt.setAutoReverse(true);
        pt.setNode(circle);
        pt.play();

        FadeTransition ft = new FadeTransition(Duration.millis(4000),circle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Animation.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();


        circle.setOnMousePressed(event -> {pt.pause();ft.pause();});
        circle.setOnMouseReleased(event -> {pt.play();ft.play();});


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
