package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.lang.management.BufferPoolMXBean;


public class Main extends Application {
    private TextField amount = new TextField();
    private TextField years = new TextField();
    private TextField rate = new TextField();
    private TextField value = new TextField();
    private Button calculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane pane = new BorderPane();
        GridPane gridPane = new GridPane();


        gridPane.add(new Label("Investment Amount: "), 0, 0);
        gridPane.add(amount, 1,0);

        gridPane.add(new Label("Number of Years: "), 0, 1);
        gridPane.add(years, 1,1);

        gridPane.add(new Label("Annual Interest Rate: "), 0, 2);
        gridPane.add(rate, 1,2);

        gridPane.add(new Label("Future value: "), 0, 3);
        gridPane.add(value, 1,3);

        pane.setCenter(gridPane);
        pane.setBottom(calculate);

        calculate.setOnAction(e->{
           calculate();
        });



        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }

    private void calculate() {
        double a = Double.parseDouble(amount.getText());
        double y = Double.parseDouble(years.getText());
        double r = Double.parseDouble(rate.getText());

        while (y-- > 0)
            a *= (1 + r / 100);
        value.setText("$"+String.valueOf(a));
    }




    public static void main(String[] args) {
        launch(args);
    }
}
