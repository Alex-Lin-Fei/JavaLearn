package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setTop(getHBox());
        pane.setLeft(getVBox());

        primaryStage.setTitle("ShowHBoxVBox");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    private VBox getVBox() {
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.getChildren().add(new Label("Course"));

        Label[] courses = {new Label("CSCI 1301"), new Label("csci 1302"), new Label("CSCI 2410")};
        for (Label course : courses) {
            VBox.setMargin(course, new Insets(0, 0, 0, 15));
            vBox.getChildren().add(course);
        }
        return vBox;
    }

    private HBox getHBox() {
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.getChildren().addAll(new Button("Computer Science"), new Button("Chemistry"));
        ImageView imageView = new ImageView(new Image("image/us.gif"));
        hBox.getChildren().add(imageView);
        return hBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
