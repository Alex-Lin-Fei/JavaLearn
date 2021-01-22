package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Random;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane pane = new BorderPane();
        CardPane cardPane = new CardPane();
        Button refresh = new Button("Refresh");

        pane.setCenter(cardPane);
        pane.setBottom(refresh);
        BorderPane.setAlignment(refresh, Pos.CENTER);
        refresh.setOnAction(e->{
            cardPane.shuffle();
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }

    class CardPane extends HBox {
        private HashSet<Integer> cards = new HashSet<>();

        CardPane() {
            setSpacing(5);
            shuffle();
        }

        public void shuffle() {
            getChildren().clear();
            cards.clear();
//            获取四个不同随机数
            Random random = new Random(System.currentTimeMillis());
            while (cards.size() < 4)
                cards.add(random.nextInt(54)+1);

//            添加ImageView
            for (int id: cards) {
                System.out.print(id+" ");
                ImageView imageView = new ImageView("file:D:\\algorithm\\JavaCode\\Introduction\\image\\card\\" + id+".png");
                getChildren().add(imageView);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
