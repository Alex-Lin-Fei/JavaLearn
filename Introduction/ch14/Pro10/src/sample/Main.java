package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setScene(new Scene(new CylinderPane()));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

class CylinderPane extends Pane {
    public CylinderPane() {
//        setWidth(200);
//        setHeight(200);
//        Ellipse ellipse1 = new Ellipse();
//
//        ellipse1.setCenterX(getWidth() / 2);
//        ellipse1.setCenterY(getHeight() / 8);
//        ellipse1.setRadiusX(getWidth() / 3);
//        ellipse1.setRadiusY(getHeight() / 9);
//        ellipse1.setStroke(Color.BLACK);
//        ellipse1.setFill(Color.WHITE);
//
//        Line line1 = new Line(ellipse1.getCenterX() - ellipse1.getRadiusX(), ellipse1.getCenterY(),
//                ellipse1.getCenterX() - ellipse1.getRadiusX(), ellipse1.getCenterY() + getHeight() * 0.6);
//
//        Line line2 = new Line(ellipse1.getCenterX() + ellipse1.getRadiusX(), ellipse1.getCenterY(),
//                ellipse1.getCenterX() + ellipse1.getRadiusX(), ellipse1.getCenterY() + getHeight() * 0.6);
//
//        Ellipse ellipse2 = new Ellipse(ellipse1.getCenterX(), ellipse1.getCenterY() + getHeight() * 0.6, ellipse1.getRadiusX(), ellipse1.getRadiusY());
//        ellipse2.setStroke(Color.BLACK);
//        ellipse2.setFill(Color.WHITE);
//        getChildren().addAll(ellipse1, ellipse2, line1, line2);

        Ellipse ellipse = new Ellipse(100, 40, 50, 20);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);

        Arc arc1 = new Arc(100, 140, 50, 20, 0, 180);
        arc1.setFill(Color.WHITE);
        arc1.setStroke(Color.BLACK);
        arc1.getStrokeDashArray().addAll(6.0, 21.0);

        Arc arc2 = new Arc(100, 140, 50, 20, 180, 180);
        arc2.setFill(Color.WHITE);
        arc2.setStroke(Color.BLACK);

        Line line1 = new Line(50, 40, 50, 140);
        Line line2 = new Line(150, 40, 150, 140);

        getChildren().addAll(ellipse, arc1, arc2, line1, line2);
    }
}
