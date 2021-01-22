package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import java.io.File;

public class Main extends Application {

//    纸牌数为4
    private final static int NUMBER_OF_POKER=4;
//    保存随机生成的1到52的数字 用于显示纸牌
    private int[] res=randomNum();
//    保存纸牌的数值
    int[] num=new int[4];

    @Override
    public void start(Stage primaryStage) throws Exception{
        Image[] images=new Image[NUMBER_OF_POKER];
        //ImageView[] imageViews=new ImageView[NUMBER_OF_POKER];
//    布局界面的下半部分  分别有verify按钮  输入表达式的输入框 以及提示输入的标签
        HBox hBox1=new HBox(5);
        Button button=new Button("Verify");
        TextField textField=new TextField();
        hBox1.getChildren().addAll(new Label("Enter a expression:"),
                textField,button);


        //pane.getChildren().add(button);
        hBox1.setAlignment(Pos.BOTTOM_LEFT);
//     布局界面的上半部分  分别有fresh重置纸牌的按钮  输出答案表达式的按钮和输出框
       HBox hBox=new HBox(5);
       Button button1=new Button("Find a Solution:");
       Button button2=new Button("Fresh");
       TextField textField1=new TextField();

       hBox.getChildren().addAll(button1,textField1,button2);

//    布局中间部分  随机显示四张纸牌
        HBox hBox2=new HBox(5);
        for(int i=0;i<4;++i){
            if(res[i]%13==0)
                num[i]=1;
            else
                num[i]=13-res[i]%13+1;
            File file=new File("src/image/picture"+res[i]+".png");
            images[i]=new Image(file.toURI().toURL().toString());
            ImageView imageView=new ImageView(images[i]);
            hBox2.getChildren().add(imageView);
        }

//     设置fresh按钮的功能
        button2.setOnAction(event -> {
//            每次重置纸牌  更新num数组保存的内容
            hBox2.getChildren().clear();
            textField1.setText(" ");
            int[] re=randomNum();
            for(int i=0;i<4;++i){
                if(re[i]%13==0)
                    num[i]=1;
                else
                    num[i]=13-re[i]%13+1;
                File file=new File("src/image/picture"+re[i]+".png");
                images[i]=new Image(file.toURI().toString());
                ImageView imageView=new ImageView(images[i]);
                hBox2.getChildren().add(imageView);
            }
        });

//        设置verify按钮的功能
        button.setOnAction(event -> {
            String str=textField.getText();
            Calculate calculate=new Calculate(str);
//            如果计算结果为24  且输出的数符合游戏规则 即四个数且和纸牌数一一对应  则正确
            if(calculate.res==24 && calculate.flag && isMatch(num,calculate.nums)){
                System.out.println("you are right");
                Answer answer=new Answer(num);
                textField1.setText(answer.res);
            }
//           反之错误
            else
                System.out.println("sorry,you are wrong");

        });

        button1.setOnAction(event -> {
//            for(int i=0;i<4;++i){
//                if(res[i]%13==0)
//                    num[i]=1;
//                else
//                    num[i]=13-res[i]%13+1;
            Answer answer=new Answer(num);
            textField1.setText(answer.res);
        });

        String string=textField.getText();

        BorderPane borderPane=new BorderPane();
        borderPane.setBottom(hBox1);
        borderPane.setTop(hBox);
        borderPane.setCenter(hBox2);




        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane,450, 450);
        primaryStage.setTitle("ShowFlowPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();

    }

//    产生四个随机数，并保存在数组中
    private static int[] randomNum(){
        int[] res=new int[4];
        int count=0;
        while(count<4){
            int num=(int)(Math.random()*52)+1;
            boolean flag=true;
            for(int i=0;i<4;++i){
                if(num==res[i]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                res[count]=num;
                count++;
            }
        }
        return res;
    }

//   检查输出的数字和纸牌的四个数是否一一对应
    public static boolean isMatch(int[] nums,int[] input) {
        int count = 0;

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (nums[i] == input[j]) {
                    count++;
                    input[j] = 0;
                    break;
                }
            }
        }
        if (count == 4)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
