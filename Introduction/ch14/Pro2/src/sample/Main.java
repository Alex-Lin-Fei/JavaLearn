package sample;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int choice = (int)(Math.random() * 3);
                if (choice == 0)
                    continue;
                File file = null;
                if (choice == 1)
                    file = new File("image/x.gif");
                else if (choice == 2)
                    file = new File("image/o.gif");
                assert file != null;
                Image image = new Image(file.toURI().toString());
                pane.add(new ImageView(image), i, j);
            }
        }
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
