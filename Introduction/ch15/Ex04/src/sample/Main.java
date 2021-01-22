package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
    TextField num1 = new TextField();
    TextField num2 = new TextField();
    TextField res = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane pane = new BorderPane();
        HBox hBox1 = new HBox(5);
        HBox hBox2 = new HBox(5);


        hBox1.getChildren().addAll(new Label("Number 1:"), num1,new Label("Number 2:"), num2,
                new Label("Result:"),res);

        Button add = new Button("Add");
        Button subtract = new Button("Subtract");
        Button multiply  = new Button("Multiply");
        Button divide = new Button("Divide");

        add.setOnAction(e->{
            add();
        });

        subtract.setOnAction(e->{
            subtract();
        });

        multiply.setOnAction(e->{
            multiply();
        });

        divide.setOnAction(e->{
            divide();
        });


        hBox2.getChildren().addAll(add, subtract, multiply, divide);
        pane.setCenter(hBox1);
        pane.setBottom(hBox2);



        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }

    public void add() {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());
        res.setText(String.valueOf(a+b));
    }

    public void subtract() {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());
        res.setText(String.valueOf(a-b));
    }


    public void multiply() {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());
        res.setText(String.valueOf(a*b));
    }


    public void divide() {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());
        try {
            res.setText(String.valueOf(a / b));
        }catch (Exception e){

        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
