package sample;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MapPane extends BorderPane {
    private Group group = new Group();

    MapPane(){
        ArrayList<ArrayList<Point2D>> points = getPoints();
        for (int i = 0; i < points.size(); i++) {
            Polygon polygon = new Polygon();
            for (int j = 0; j < points.get(i).size(); j++) {
                polygon.getPoints().addAll(points.get(i).get(j).getX(),
                        points.get(i).get(j).getY());
            }
            polygon.setFill(Color.WHITE);
            polygon.setStroke(Color.BLACK);
            polygon.setStrokeWidth(1 / 14.0);

            polygon.setOnMouseClicked(e->{
                if (e.getButton() == MouseButton.PRIMARY)
                    polygon.setFill(Color.RED);
                else if (e.getButton() == MouseButton.SECONDARY)
                    polygon.setFill(Color.BLUE);
                else
                    polygon.setFill(Color.WHITE);
            });
            group.getChildren().add(polygon);
        }
        group.setScaleX(40);
        group.setScaleY(40);
        this.setCenter(group);
    }

    public void enlarge() {
        group.setScaleX(1.1 * group.getScaleX());
        group.setScaleY(1.1 * group.getScaleY());
    }

    public void shrink() {
        group.setScaleX(.9 * group.getScaleX());
        group.setScaleY(.9 * group.getScaleY());
    }

    private ArrayList<ArrayList<Point2D>> getPoints() {
        ArrayList<ArrayList<Point2D>> points = new ArrayList<>();

        try (Scanner input = new Scanner(
                new URL("https://liveexample.pearsoncmg.com/data/usmap.txt")
                        .openStream())){
            while(input.hasNext()) {
                String s = input.nextLine();
                if (Character.isAlphabetic(s.charAt(0))) {
                    points.add(new ArrayList<>());
                }
                else {
                    Scanner scanAString = new Scanner(s);
                    double y = scanAString.nextDouble();
                    double x = scanAString.nextDouble();
                    points.get(points.size() - 1).add(new Point2D(x, y));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return points;
    }
}
