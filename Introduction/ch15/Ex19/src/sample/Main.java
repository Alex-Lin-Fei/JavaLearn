package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Circle circle = new Circle(10);

        pane.getChildren().add(circle);

        FadeTransition ft1 = new FadeTransition(Duration.millis(3000), circle);
        ft1.setFromValue(1.0);
        ft1.setToValue(0);
        ft1.setCycleCount(1);


        FadeTransition ft2 = new FadeTransition(Duration.millis(3000), circle);
        ft2.setFromValue(0.0);
        ft2.setToValue(1.0);
        ft2.setCycleCount(1);


        circle.setOnMouseClicked(event -> {
            ft1.play();

            circle.setCenterX(pane.getWidth()*Math.random());
            circle.setCenterY(pane.getHeight()*Math.random());
            ft2.play();
        });


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();

        circle.setCenterX(pane.getWidth() * Math.random());
        circle.setCenterY(pane.getHeight() * Math.random());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
