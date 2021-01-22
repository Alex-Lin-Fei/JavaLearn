package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        Text text = new Text(20,20,"Welcome to Java");

        text.setOnMouseClicked(e->{
            if (text.getText().equals("Welcome to Java"))
                text.setText("Learning JavaFX");
            else
                text.setText("Welcome to Java");
        });

        pane.getChildren().add(text);



        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
