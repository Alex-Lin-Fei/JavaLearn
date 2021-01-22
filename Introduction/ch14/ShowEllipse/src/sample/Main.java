package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(new MyEllipse(), 300, 200);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class MyEllipse extends Pane{
        private void paint() {
            getChildren().clear();
            for (int i = 0; i< 16; i++) {
                Ellipse e = new Ellipse(getWidth() / 2,
                        getHeight()/2, getWidth()/2-50, getHeight()/2-50);
                e.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
                e.setFill(Color.WHITE);
                e.setRotate(i*180/16);
                getChildren().add(e);
            }
        }


        @Override
        public void setHeight(double height) {
            super.setHeight(height);
//            System.out.println("height paint");
//            paint();
        }

        @Override
        public void setWidth(double width) {
            super.setWidth(width);
            System.out.println("width paint");
            paint();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
