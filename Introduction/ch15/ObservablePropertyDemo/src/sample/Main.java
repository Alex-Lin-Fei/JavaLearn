package sample;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DoubleProperty balance = new SimpleDoubleProperty();
        balance.addListener(observable -> System.out.println("The new value is " + balance.doubleValue()));

        balance.setValue(3);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
