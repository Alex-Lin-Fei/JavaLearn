package sample;

import com.sun.deploy.xml.XMLable;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import java.lang.Exception;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private HBox paneForSpeed=new HBox(5);
    private VBox paneForCar=new VBox(180);
    private ObservableList<Node> textField=paneForSpeed.getChildren();
    private ObservableList<Node> car=paneForCar.getChildren();

    @Override
    public void start(Stage primaryStage) throws Exception{

      paneForSpeed.setAlignment(Pos.CENTER);

      for(int i=1;i<=4;++i){
          paneForSpeed.getChildren().addAll(new Label("Car"+i+":"),new TextField());
      }

      for(int i=1;i<textField.size();i+=2){
          ((TextField)textField.get(i)).setPrefColumnCount(2);
      }

      for(int i=1;i<=4;++i){
          paneForCar.getChildren().add(new Car());
      }

      for(int i=1;i<textField.size();i+=2){
          (textField.get(i)).setOnKeyPressed(e->{
                     if (e.getCode() == KeyCode.ENTER){ setSpeed();}
                  }
                  );

      }

      BorderPane borderPane=new BorderPane();
      borderPane.setTop(paneForSpeed);
      borderPane.setCenter(paneForCar);

      Scene scene=new Scene(borderPane,400,250);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Car race");
      primaryStage.show();
    }

//    为小车设置速度
    private void setSpeed(){
        for(int i=1,j=0;i<textField.size();i+=2,++j){
            if(((TextField)textField.get(i)).getText().length()>0){
                ((Car)car.get(j)).setSpeed(Double.parseDouble(((TextField)textField.get(i)).getText()));
                ((Car)car.get(j)).play();

                }
            else{
                ((Car) car.get(j)).pause();
            }
            }
        }

    public static void main(String[] args) {
        launch(args);
    }
}
