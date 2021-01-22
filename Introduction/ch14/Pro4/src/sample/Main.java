package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       HBox hBox = new HBox(15);

       Label label1 = new Label("JavaFX");
       label1.setRotate(90);
       label1.setFont(Font.font("Times New Roman",
               FontWeight.BOLD, FontPosture.ITALIC, 24));
       hBox.getChildren().add(label1);

        Label label2 = new Label("JavaFX");
        label2.setRotate(90);
        label2.setFont(Font.font("Bold",
                FontWeight.BOLD, FontPosture.ITALIC, 24));
        hBox.getChildren().add(label2);

        Label label3 = new Label("JavaFX");
        label3.setRotate(90);
        label3.setFont(Font.font("Italic",
                FontWeight.BOLD, FontPosture.ITALIC, 24));
        hBox.getChildren().add(label3);

        Label label4 = new Label("JavaFX");
        label4.setRotate(90);
        label4.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 24));
        hBox.getChildren().add(label4);

        Label label5 = new Label("JavaFX");
        label5.setRotate(90);
        label5.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 24));
        hBox.getChildren().add(label5);

       Scene scene = new Scene(hBox);
       primaryStage.setScene(scene);
       primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
