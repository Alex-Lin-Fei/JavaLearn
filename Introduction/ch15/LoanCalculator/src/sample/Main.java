package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfTotalPayment = new TextField();
    private Button btCalculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) throws Exception{
       GridPane pane = new GridPane();
       pane.setHgap(5);
       pane.setVgap(5);

       pane.add(new Label("Annual Interest Rate:"), 0,0);
       pane.add(tfAnnualInterestRate, 1,0);

        pane.add(new Label("Number of Years:"), 0,1);
        pane.add( tfNumberOfYears,1,1);

        pane.add(new Label("Loan Amount:"), 0,2);
        pane.add(tfLoanAmount, 1,2);

        pane.add(new Label("Monthly Payment:"), 0,3);
        pane.add(tfMonthlyPayment, 1,3);

        pane.add(new Label("Total Payment:"), 0,4);
        pane.add(tfTotalPayment, 1,4);

        pane.add(btCalculate, 1, 5);

        btCalculate.setOnAction(e->calculateLoanPayment());

       Scene scene = new Scene(pane);
       primaryStage.setTitle("Loan Calculator");
       primaryStage.setScene(scene);
       primaryStage.show();
    }

private void calculateLoanPayment() {
        double interest = Double.parseDouble(tfAnnualInterestRate.getText());
        int year = Integer.parseInt(tfNumberOfYears.getText());
        tfMonthlyPayment.setText("monthly");
        tfTotalPayment.setText("year");
}
    public static void main(String[] args) {
        launch(args);
    }
}
