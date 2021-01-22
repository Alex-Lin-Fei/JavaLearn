package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    private String string="";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();
        Text text = new Text(100,100,"first");

        pane.getChildren().add(text);

        pane.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.ENTER) {
                text.setText(string);
                string="";
            }
            else
                string += e.getCode();
        });



        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();

        pane.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
