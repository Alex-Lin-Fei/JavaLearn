package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();
        ClockPane clockPane = new ClockPane();


        pane.getChildren().add(clockPane);
        EventHandler<ActionEvent> handler = e->{
            clockPane.setTime();
        };

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), handler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }

    class ClockPane extends Pane {
//        数据域包括时、分、秒
        private int hour;
        private int minute;
        private int second;
        private int w = 400, h = 400;


        ClockPane() {
            setWidth(400);
            setHeight(400);
            setTime();
        }

//        大小

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }

        public int getSecond() {
            return second;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        public void setTime() {
            Calendar calendar = new GregorianCalendar();
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);
            second = calendar.get(Calendar.SECOND);

            paintClock();
        }

        public void paintClock() {
            double radius = Math.min(w, h) * 0.4;
            double centerX = getWidth() / 2;
            double centerY = getHeight() / 2;

//            ⚪
            Circle circle = new Circle(centerX, centerY, radius);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);

//            指针
            double hLen = radius * 0.3;
            double hx = centerX + hLen*Math.sin((hour + 1.0 * minute / 60) * (Math.PI / 6));
            double hy = centerY - hLen*Math.cos((hour + 1.0 * minute / 60) * (Math.PI / 6));
            Line h = new Line(centerX, centerY, hx, hy);
            h.setStroke(Color.RED);

            double mLen = radius * 0.6;
            double mx = centerX + mLen*Math.sin((minute / 5.0 + 1.0 * second / 60) * (Math.PI / 6));
            double my = centerY - mLen*Math.cos((minute / 5.0 + 1.0 * second / 60) * (Math.PI / 6));
            Line m = new Line(centerX, centerY, mx, my);
            m.setStroke(Color.BLUE);


            double sLen = radius * 0.8;
            double sx = centerX + sLen*Math.sin(second / 5.0 * (Math.PI / 6));
            double sy = centerY - sLen* Math.cos(second / 5.0 * (Math.PI / 6));
            Line s = new Line(centerX, centerY, sx, sy);
            s.setStroke(Color.GREEN);


//            3 6 9 12
            double x = centerX + radius;
            double y = centerY;
            double ex = x - radius / 8.0;
            double ey = y;
            Line l1 = new Line(x, y, ex, ey);
            l1.setStroke(Color.BLACK);
            Text t1 = new Text(ex,ey,"3");

            x = centerX;
            y = centerY + radius;
            ex = x;
            ey = y - radius / 8.0;
            Line l2 = new Line(x, y, ex, ey);
            l2.setStroke(Color.BLACK);
            Text t2 = new Text(ex,ey,"6");

            x = centerX - radius;
            y = centerY;
            ex = x + radius / 8.0;
            ey = y;
            Line l3 = new Line(x, y, ex, ey);
            l3.setStroke(Color.BLACK);
            Text t3 = new Text(ex,ey,"9");

            x = centerX;
            y = centerY - radius;
            ex = x;
            ey = y + radius / 8.0;
            Line l4 = new Line(x, y, ex, ey);
            l4.setStroke(Color.BLACK);
            Text t4 = new Text(ex,ey,"12");

            Text time = new Text(centerX-30,centerY+radius+20,hour+":"+minute+":"+second);

            getChildren().clear();
            getChildren().addAll(circle, h, m, s,t1,l1,t2,l2,t3,l3,t4,l4);
            getChildren().add(time);
            System.out.println(radius);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
