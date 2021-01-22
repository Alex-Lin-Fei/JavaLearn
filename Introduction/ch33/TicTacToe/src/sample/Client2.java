package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client2 extends Application implements TicTacToeConstants {
    private Cell[][] cells = new Cell[3][3];
    private boolean myTurn =false;
    private boolean continueToPlay = true;
    private boolean waiting = true;
    private char myToken;
    private char otherToken;
    private Socket socket;
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    private String host = "localhost";
    private int port = 8000;

    private Label lblStatus = new Label();
    private Label lblTitle = new Label();

    private int rowSelected;
    private int colSelected;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        init GUI
        GridPane gridPane = new GridPane();
        for (int i = 0; i < cells.length; i++)
            for (int j =0; j < cells[i].length; j++)
                gridPane.add(cells[i][j],j,i);

        BorderPane pane = new BorderPane();
        pane.setTop(lblTitle);
        pane.setCenter(gridPane);
        pane.setBottom(lblStatus);

//        连接服务器
        connectToServer();
    }

    private void connectToServer() {
//        连接
        try {
            socket = new Socket(host, port);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        }catch (Exception e){
        }

        new Thread(()->{
            try{
                int player = fromServer.readInt();

                if (player == PLAYER1){
                    myToken = 'x';
                    otherToken = 'o';
                    Platform.runLater(()->{
                        lblTitle.setText("Player 1 with token 'X'");
                        lblStatus.setText("Waiting for player 2 to join");
                    });

//                    接收开始信号
                    fromServer.readInt();

                    Platform.runLater(()->{
                        lblStatus.setText("Player 2 has joined. I start first");
                    });
                    myTurn = true;
                }
                else if (player == PLAYER2) {
                    myToken = 'o';
                    otherToken = 'x';
                    Platform.runLater(()->{
                        lblTitle.setText("Player 2 with token o");
                        lblStatus.setText("Waiting player 1 to move");
                    });
                }

                while (continueToPlay) {
                    if (player == PLAYER1){
                        waitForPlayerAction();
                        sendMove();
                        receivedInfoFromServer();
                    }
                    else {
                        receivedInfoFromServer();
                        waitForPlayerAction();
                        sendMove();
                    }
                }
            }catch (Exception e) { }
        }).start();
    }

    private void waitForPlayerAction() throws InterruptedException {
        while (waiting)
            Thread.sleep(1000);
        waiting = true;
    }

    private void sendMove() throws IOException {
        toServer.writeInt(rowSelected);
        toServer.writeInt(colSelected);
    }

    private void receiveMove() throws IOException {
        int row = fromServer.readInt();
        int col = fromServer.readInt();
        cells[row][col].setToken(otherToken);
    }

    private void receivedInfoFromServer() throws IOException {
        int status = fromServer.readInt();

        switch (status) {
            case PLAYER1_WON: {
                continueToPlay = false;
                if (myToken == 'x') {
                    Platform.runLater(() -> {
                        lblStatus.setText("I won! (X)");
                    });
                } else {
                    Platform.runLater(() -> {
                        lblStatus.setText("Player 1 (X) won!");
                    });
                    receiveMove();
                }
            }
            break;
            case PLAYER2_WON: {
                continueToPlay = false;
                if (myToken == 'o') {
                    Platform.runLater(() -> {
                        lblStatus.setText("I won! (O)");
                    });
                } else {
                    Platform.runLater(() -> {
                        lblStatus.setText("Player 1 (O) won!");
                    });
                    receiveMove();
                }
            }
            break;
            case DRAW: {
                continueToPlay = false;
                Platform.runLater(() -> {
                    lblStatus.setText("Game is over, no winner!");
                });
                if (myToken == 'o')
                    receiveMove();
            }
            break;
            case CONTINUE: {
                receiveMove();
                Platform.runLater(() -> {
                    lblStatus.setText("My turn");
                });
                myTurn = true;
            }

            break;
            default:
                break;
        }
    }

    class Cell extends Pane {
        private int row;
        private int col;
        private char token;

        Cell(int row, int col) {
            token = ' ';
            this.row = row;
            this.col = col;
            this.setPrefSize(2000,2000);
            setStyle("-fx-border-color: black");
            this.setOnMouseClicked(e -> handleMouse());
        }

        public void paintCell() {
            if (token == 'x') {
                Line line1 = new Line(10, 10, this.getWidth() - 10, this.getHeight() - 10);
                line1.endXProperty().bind(this.widthProperty().subtract(10));
                line1.endYProperty().bind(this.heightProperty().subtract(10));

                Line line2 = new Line(this.getWidth() - 10, 10, 10, this.getHeight() - 10);
                line2.startXProperty().bind(this.widthProperty().subtract(10));
                line2.endYProperty().bind(this.heightProperty().subtract(10));
                this.getChildren().addAll(line1, line2);
            } else {
                Ellipse ellipse = new Ellipse(this.getWidth() / 2, this.getHeight() / 2, this.getWidth() / 2 - 10,
                        this.getHeight() / 2 - 10);
                ellipse.centerXProperty().bind(this.widthProperty().divide(2));
                ellipse.centerYProperty().bind(this.heightProperty().divide(2));
                ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
                ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
                ellipse.setFill(Color.WHITE);
                ellipse.setStroke(Color.BLACK);

                getChildren().add(ellipse);
            }
        }

        public void setToken(char c) {
            token = c;
            paintCell();
        }

        public void handleMouse() {
            if (token == ' ' && myTurn) {
                setToken(myToken);
                myTurn = false;
                rowSelected = row;
                colSelected = col;
                lblStatus.setText("Waiting for the other player to move");
                waiting = false;
            }
        }
    }
}
