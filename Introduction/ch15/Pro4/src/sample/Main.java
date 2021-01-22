package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
    public Label label1 = new Label("Number 1: ");
    public TextField textField1 = new TextField();

    public Label label2 = new Label("Number 2: ");
    public TextField textField2 = new TextField();

    public Label label3 = new Label("Result: ");
    public TextField textField3 = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox hBox = new HBox(5);

        hBox.getChildren().addAll(label1, textField1,label2, textField2, label3,
                 textField3);

        HBox hBox1 = new HBox(5);
        Button add = new Button("Add");
        Button subtract = new Button("Subtract");
        Button multiply = new Button("Multiply");
        Button divide = new Button("Divide");

        hBox1.getChildren().addAll(add, subtract, multiply, divide);
        hBox1.setAlignment(Pos.CENTER);

        add.setOnAction(e->{
            add();
        });

        subtract.setOnAction(e->{
            subtract();
        });

        multiply.setOnAction(e->
                multiply());

        divide.setOnAction(e->{
            try{
                divide();
            }
            catch (ArithmeticException ex) {
                ex.printStackTrace();
            }
        });

        BorderPane pane = new BorderPane();
        pane.setBottom(hBox1);
        pane.setCenter(hBox);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    public void add() {
        double num1 = Double.parseDouble(textField1.getText());
        double num2 = Double.parseDouble(textField2.getText());
        double res = num1 + num2;
        textField3.setText(String.valueOf(res));
    }

    public void subtract() {
        double num1 = Double.parseDouble(textField1.getText());
        double num2 = Double.parseDouble(textField2.getText());
        double res = num1 - num2;
        textField3.setText(String.valueOf(res));
    }

    public void multiply() {
        double num1 = Double.parseDouble(textField1.getText());
        double num2 = Double.parseDouble(textField2.getText());
        double res = num1 * num2;
        textField3.setText(String.valueOf(res));
    }

    public void divide() throws ArithmeticException {
        double num1 = Double.parseDouble(textField1.getText());
        double num2 = Double.parseDouble(textField2.getText());
        if (num2 == 0)
            throw new ArithmeticException();

        double res = num1 / num2;
        textField3.setText(String.valueOf(res));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
