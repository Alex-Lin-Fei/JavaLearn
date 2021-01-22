package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;

public class Server extends Application implements TicTacToeConstants {
    private ServerSocket serverSocket;
    private int port = 8000;
    private int sessionNo = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        初始化GUI
        TextArea taLog = new TextArea();
        Scene scene = new Scene(new ScrollPane(taLog), 450,200);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(()->{
            try {
                serverSocket = new ServerSocket(port);
                Platform.runLater(()->{taLog.appendText(new Date()+": Server started at socket "+port+"\n");});

//            接收玩家
                while (true) {
                    Platform.runLater(()->{taLog.appendText(new Date()+": Wait for players to join session "+sessionNo+"\n");});

//                    连接玩家1
                    Socket player1 = serverSocket.accept();
                    new DataOutputStream(player1.getOutputStream()).writeInt(PLAYER1);
                    Platform.runLater(()->{
                        taLog.appendText(new Date()+": Player 1 joined session "+sessionNo+"\n");
                        taLog.appendText("Player 1`s IP address " + player1.getInetAddress().getHostAddress()+"\n");
                    });

                    Socket player2 = serverSocket.accept();
                    new DataOutputStream(player2.getOutputStream()).writeInt(PLAYER2);
                    Platform.runLater(()->{
                        taLog.appendText(new Date()+": Player 2 joined session "+sessionNo+"\n");
                        taLog.appendText("Player 2`s IP address " + player2.getInetAddress().getHostAddress()+"\n");
                    });

                    Platform.runLater(()->{
                        taLog.appendText(new Date() + "Start a thread for session " + sessionNo +"\n");
                    });
                    new Thread(new HandlerSession(player1, player2)).start();
                }
            }catch (IOException ex){}

        }).start();


    }

    class HandlerSession implements Runnable{
        private Socket player1;
        private Socket player2;

        private DataInputStream fromPlayer1;
        private DataInputStream fromPlayer2;
        private DataOutputStream toPlayer1;
        private DataOutputStream toPlayer2;

        private char[][] cells = new char[3][3];

        HandlerSession(Socket player1, Socket player2) {
            this.player1 = player1;
            this.player2 = player2;

            for (char[] cell : cells) Arrays.fill(cell, ' ');
        }

        @Override
        public void run() {
            try{
                fromPlayer1 = new DataInputStream(player1.getInputStream());
                toPlayer1 = new DataOutputStream(player1.getOutputStream());
                fromPlayer2 = new DataInputStream(player2.getInputStream());
                toPlayer2 = new DataOutputStream(player2.getOutputStream());

//                通知玩家1开始游戏
                toPlayer1.writeInt(1);
                while (true) {
//                    接收玩家1的动作
                    int row = fromPlayer1.readInt();
                    int col = fromPlayer1.readInt();
                    cells[row][col] = 'X';

//                    判断1是否获胜
                    if (isWon('X')) {
                        toPlayer1.writeInt(PLAYER1_WON);
                        toPlayer2.writeInt(PLAYER1_WON);
                        sendMove(toPlayer2, row, col);
                        break;
                    }
                    else if (isDraw()) {
                        toPlayer1.writeInt(DRAW);
                        toPlayer2.writeInt(DRAW);
                        sendMove(toPlayer2, row, col);
                        break;
                    }
//                    通知玩家2继续 并发送玩家一的动作
                    else{
                        toPlayer2.writeInt(CONTINUE);
                        sendMove(toPlayer2,row,col);
                    }

//                    接收玩家2的动作
                    row = fromPlayer2.readInt();
                    col = fromPlayer2.readInt();

//                    判断玩家2是否获胜
                    if (isWon('O')) {
                        toPlayer1.writeInt(PLAYER2_WON);
                        toPlayer2.writeInt(PLAYER2_WON);
                        sendMove(toPlayer1,row,col);
                        break;
                    }

//                    通知玩家1继续 并发送玩家2的动作
                    else{
                        toPlayer1.writeInt(CONTINUE);
                        sendMove(toPlayer1,row,col);
                    }
                }
            }catch (IOException e){}
        }

        public void sendMove(DataOutputStream out, int row, int col) throws IOException {
            out.writeInt(row);
            out.writeInt(col);
        }

        public boolean isWon(char token) {
//            每一行
            for (char[] cell: cells)
                if (cell[0] == cell[1] && cell[1] == cell[2] &&cell[0] == token)
                    return true;

//            每一列
            for (int i = 0; i < cells.length; i++)
                if (cells[0][i] == cells[1][i] && cells[0][i] == cells[2][i] && cells[0][i] ==token)
                    return true;

//            对角线
            if (cells[1][1] == token) {
                return cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2] ||
                        cells[0][2] == cells[1][1] && cells[2][0] == cells[1][1];
            }
            return false;
        }

        public boolean isDraw() {
            for (char[] cell : cells)
                for (char ch : cell)
                    if (ch == ' ')
                        return false;
            return true;
        }
    }
}
