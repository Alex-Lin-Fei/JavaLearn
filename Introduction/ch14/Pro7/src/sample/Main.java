package sample;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.text.TabExpander;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        int width = 5;
        int height = 5;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                TextField textField = new TextField();
                String str = (Math.random() > 0.5) ? "1" : "0";
                textField.setText(str);
                textField.setPrefColumnCount(1);
                pane.add(textField, i, j);
            }
        }


        Scene scene = new Scene(pane, 50, 50);
        primaryStage.setTitle("Show Text");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

