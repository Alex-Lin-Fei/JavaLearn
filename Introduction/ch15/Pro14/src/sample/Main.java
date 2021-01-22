package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Polygon polygon = new Polygon();

        double[] x = {30, 60, 50, 35, 10};
        double[] y = {10, 60, 70, 35, 50};

        ObservableList<Double> list = polygon.getPoints();
        for (int i = 0; i < x.length; i++)
            list.addAll(x[i], y[i]);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLUE);

        Pane pane = new Pane();
        pane.getChildren().add(polygon);

        pane.setOnMouseMoved(e->{
            pane.getChildren().clear();
            pane.getChildren().add(polygon);
            double x_ = e.getX();
            double y_ = e.getY();
            String str = "Mouse point is ";
            int crossings = 0;
            for (int i = 0; i < x.length; i++) {
                double slope = (y[(i + 1) % x.length] - y[i]) / (x[(i + 1) % x.length] - x[i]);
                boolean cond1 = (x[i] <= x_ && x_ < x[(i + 1) % x.length]);
                boolean cond2 = (x[(i + 1) % x.length] <= x_ && x_ < x[i]);
                boolean above = (y_ < slope * (x_ - x[i]) + y[i]);
                if ((cond1 || cond2) && above)
                    crossings++;
            }
            if (crossings % 2 != 0)
                str += "inside";
            else
                str += "outside";
            str += " the polygon";
            Text text = new Text(x_, y_, str);
            pane.getChildren().add(text);
        });

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
        pane.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
