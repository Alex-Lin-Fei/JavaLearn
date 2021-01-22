package sample;

import java.awt.*;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import javafx.scene.shape.Line;


public class Car extends Pane {
    private double speed;
    private double x;
    private double y;
    private Timeline animation;

    public Car(){
        drawCar();
        animation=new Timeline(new KeyFrame(Duration.millis(50),e->go()));
        animation.setCycleCount(Timeline.INDEFINITE);

    }

    public void drawCar(){
        Rectangle rec=new Rectangle(x,y,40,10);
        rec.setStroke(Color.GREEN);
        rec.setFill(Color.GREEN);
        Circle c1=new Circle(x+6.6,y+15,5);
        Circle c2=new Circle(x+33.3,y+15,5);
        c1.setStroke(Color.BLACK);
        c1.setFill(Color.BLACK);
        c2.setStroke(Color.BLACK);
        c2.setFill(Color.BLACK);
        Polygon polygon=new Polygon();
        polygon.setStroke(Color.RED);
        polygon.setFill(Color.RED);
        ObservableList<Double> list = polygon.getPoints();

        double centerX=x+20;
        double centerY=y;
        double radius=12;

        for(int i=0;i<4;++i){
            list.add(centerX+radius*Math.cos(i*Math.PI/3));
            list.add(centerY-radius*Math.sin(i*Math.PI/3));
        }

        Line line=new Line(0,y+20,getWidth(),y+20);

        getChildren().clear();
        getChildren().addAll(c1,c2,rec,polygon,line);
    }

    public void play() {
        animation.play();
    }

    public void pause(){
        animation.pause();
    }

    public void setSpeed(double speed){
        animation.setRate(speed);
    }

    public void go(){
        if(x<=getWidth())
            x+=1;
        else
        {
            x=0;
            this.pause();
        }
        drawCar();
    }
}
