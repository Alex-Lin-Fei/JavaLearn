package sample;

import javafx.application.Application;
import javafx.embed.swt.SWTFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        Text text = new Text(20,20,"A");
        pane.getChildren().add(text);

        text.setOnKeyPressed(e->{
            switch (e.getCode()) {
                case DOWN:
                    text.setY(text.getY() + 10);
                    break;
                case UP:
                    text.setY(text.getY() - 10);
                    break;
                case LEFT:
                    text.setX(text.getX() - 10);
                    break;
                case RIGHT:
                    text.setX(text.getX() + 10);
                    break;
                default:
                    if (e.getText().length() > 0)
                        text.setText(e.getText());
            }
        });



        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();

        text.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
