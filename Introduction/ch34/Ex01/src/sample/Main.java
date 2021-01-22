package sample;

import com.sun.javafx.charts.Legend;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {
    private TextField tfID;
    private TextField tfLastName;
    private TextField tfFirstName;
    private TextField tfMI;
    private TextField tfAddress;
    private TextField tfCity;
    private TextField tfState;
    private TextField tfTelephone;
    private TextField tfEmail;

    private Button btView;
    private Button btInsert;
    private Button btUpdate;
    private Button btClear;

    private PreparedStatement stmtView;
    private PreparedStatement stmtInsert;
    private PreparedStatement stmtUpdate;

    private String viewString = "select * from Staff where id = ?;";
    private String insertString = "insert into Staff values(?, ?, ?,?,?,?,?,?,?);";
    private String updateString = "update Staff set lastName = ?, firstName = ?";

    private String DRIVER = "Driver loaded";
    private String URL ="jdbc:mysql://localhost:3306/javabook?serverTimezone=GMT%2B8";
    private String USER = "root";
    private String PASSWORD= "131125fei";

    private Label lblStatus;



    @Override
    public void start(Stage primaryStage) throws Exception{
        initDB();

//        初始化GUI
        lblStatus = new Label();

        tfID = new TextField();
        tfLastName = new TextField();
        tfFirstName = new TextField();
        tfMI = new TextField();
        tfAddress = new TextField();
        tfCity = new TextField();
        tfState = new TextField();
        tfTelephone = new TextField();
        tfEmail = new TextField();

        tfMI.setPrefColumnCount(1);

        btView = new Button("View");
        btInsert = new Button("Insert");
        btUpdate = new Button("Update");
        btClear = new Button("Clear");

        HBox hBox1 = new HBox(5);
        hBox1.getChildren().addAll(new Label("ID"), tfID);
        HBox hBox2 = new HBox(5);
        hBox2.getChildren().addAll(new Label("Last Name"), tfLastName,
                new Label("First Name"), tfFirstName, new Label("MI"), tfMI);
        HBox hBox3 = new HBox(5);
        hBox3.getChildren().addAll(new Label("Address"), tfAddress);
        HBox hBox4 = new HBox(5);
        hBox4.getChildren().addAll(new Label("City"), tfCity, new Label("State"), tfState);
        HBox hBox5 = new HBox(5);
        hBox5.getChildren().addAll(new Label("Telephone"), tfTelephone, new Label("Email"), tfEmail);

        HBox hBox6 = new HBox(5);
        hBox6.getChildren().addAll(btView, btInsert,btUpdate,btClear);
        hBox6.setAlignment(Pos.BOTTOM_CENTER);

        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(lblStatus, hBox1, hBox2, hBox3, hBox4, hBox5, hBox6);

        btView.setOnAction(e->view());
        btInsert.setOnAction(e->insert());
        btUpdate.setOnAction(e->update());


        primaryStage.setTitle("ExtraExercise34_01");
        primaryStage.setScene(new Scene(vBox, 300, 275));
        primaryStage.show();
    }

    public void initDB() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(DRIVER);
            Connection connection = DriverManager.getConnection(
                    URL, USER, PASSWORD
            );
            System.out.println("Database connected");
//            初始化 preparedStatement
            stmtInsert = connection.prepareStatement(insertString);
            stmtView = connection.prepareStatement(viewString);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public  void view() {
        String id = tfID.getText();
        try{
            stmtView.setString(1, id);
            ResultSet rset = stmtView.executeQuery();
            if (rset.next()) {
                String lastName = rset.getString(2);
                String firstName = rset.getString(3);
                String mi= rset.getString(4);
                String address = rset.getString(5);
                String city = rset.getString(6);
                String state = rset.getString(7);
                String telephone = rset.getString(8);
                String email =rset.getString(9);

                tfLastName.setText(lastName);
                tfFirstName.setText(firstName);
                tfMI.setText(mi);
                tfAddress.setText(address);
                tfCity.setText(city);
                tfState.setText(state);
                tfTelephone.setText(telephone);
                tfEmail.setText(email);
                lblStatus.setText("view successfully");
            }
            else{
                lblStatus.setText("Not found");
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void insert() {
        String id = tfID.getText();
        String lastName = tfLastName.getText();
        String firstName = tfFirstName.getText();
        String mi= tfMI.getText();
        String address = tfAddress.getText();
        String city = tfCity.getText();
        String state = tfState.getText();
        String telephone = tfTelephone.getText();
        String email = tfEmail.getText();

        try{
            stmtInsert.setString(1, id);
            stmtInsert.setString(2, lastName);
            stmtInsert.setString(3, firstName);
            stmtInsert.setString(4, mi);
            stmtInsert.setString(5, address);
            stmtInsert.setString(6, city);
            stmtInsert.setString(7, state);
            stmtInsert.setString(8,telephone);
            stmtInsert.setString(9, email);

            stmtInsert.executeUpdate();
            lblStatus.setText("Insert successfully");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update() {

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
