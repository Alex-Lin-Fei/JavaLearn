package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.Callable;


public class Main extends Application {
    private int speed = 2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane pane = new BorderPane();
        HBox hBox = new HBox(5);

        Circle circle = new Circle(200,120,100);
        circle.setFill(Color.WHITE);

        Arc arc1 = new Arc(200,120,85,85,0,40);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.BLACK);
        Arc arc2 = new Arc(200,120,85,85,60,40);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.RED);
        Arc arc3 = new Arc(200,120,85,85,120,40);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.BLACK);
        Arc arc4 = new Arc(200,120,85,85,180,40);
        arc4.setType(ArcType.ROUND);
        arc4.setFill(Color.RED);
        Arc arc5 = new Arc(200,120,85,85,240,40);
        arc5.setType(ArcType.ROUND);
        arc5.setFill(Color.BLACK);
        Arc arc6 = new Arc(200,120,85,85,300,40);
        arc6.setType(ArcType.ROUND);
        arc6.setFill(Color.RED);


        Group group = new Group();
        group.getChildren().addAll(circle,arc1,arc2,arc3,arc4,arc5,arc6);

        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button reverse = new Button("Reserve");
        hBox.getChildren().addAll(pause,resume,reverse);
        hBox.setAlignment(Pos.CENTER);

        pane.setCenter(group);
        pane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Timeline animatiion = new Timeline(new KeyFrame(Duration.millis(30), event -> {
            arc1.setStartAngle(arc1.getStartAngle()+speed);
            arc2.setStartAngle(arc2.getStartAngle()+speed);
            arc3.setStartAngle(arc3.getStartAngle()+speed);
            arc4.setStartAngle(arc4.getStartAngle()+speed);
            arc5.setStartAngle(arc5.getStartAngle()+speed);
            arc6.setStartAngle(arc6.getStartAngle()+speed);
        }));

        animatiion.setCycleCount(Animation.INDEFINITE);
        animatiion.play();

        pause.setOnAction(event -> animatiion.pause());
        resume.setOnAction(event -> animatiion.play());
        reverse.setOnAction(event -> speed *=-1);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
