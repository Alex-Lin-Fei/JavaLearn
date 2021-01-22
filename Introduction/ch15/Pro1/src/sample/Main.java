package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedInputStream;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox(5);
        randomCard(hBox);
        BorderPane pane = new BorderPane();
        pane.setCenter(hBox);

        Button refresh = new Button("Refresh");
        refresh.setOnAction(e->randomCard(hBox));

        pane.setBottom(refresh);
        BorderPane.setAlignment(refresh, Pos.BOTTOM_CENTER);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

    public void randomCard(HBox hBox) {
        boolean[] isUsed = new boolean[52];
        int count = 0;
        hBox.getChildren().clear();
        while (count < 4) {
            int choice = (int)(Math.random() * 52);
            if (!isUsed[choice]) {
                count++;
                File file = new File("image/card/" + (choice+1) + ".png");
                Image image = new Image(file.toURI().toString());
                hBox.getChildren().add(new ImageView(image));
                isUsed[choice] = true;
            }
        }
    }
}

