package com.company;

import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        char[][] board = new char[3][3];
        boolean over = false;

        while(!over){
            Move(board,'X');
            displayBoard(board);
            if(isWon(board)){
                System.out.println("player X is winner");
                exit(0);
            }
            else if(isDraw(board)) {
                System.out.println("is in a draw");
                exit(0);
            }
            Move(board,'O');
            displayBoard(board);
            if(isWon(board)){
                System.out.println("player O is winner");
                exit(0);
            }
            else if(isDraw(board)) {
                System.out.println("is in a draw");
                exit(0);
            }
        }
    }

    public static void Move(char[][] board,char trick){
        boolean done = false;
        int row;
        int column;

        do{
            System.out.print("Enter a row (1,2,or 3) for player "+trick+":");
            row = scanner.nextInt();
            System.out.print("Enter a column (1,2 or 3) for player "+trick+":");
            column = scanner.nextInt();
            if(board[row][column]=='\0'){
                done = true;
                board[row][column]=trick;
            }
            else
                System.out.println("location error,please enter again");
        }while(!done);
    }

    public static void displayBoard(char[][] board){
        System.out.println("\n—— —— ——");
        for(int i=0;i<3;i++){
            System.out.print("|");
            for(int j=0;j<3;j++)
                System.out.print(board[i][j]=='\0' ?"  |":board[i][j]+"|");
            System.out.println();
            System.out.println("—— —— ——");
        }
    }

    public static boolean isWon(char[][] board){
        for(int i=0;i<3;i++)
            if(board[i][0]!='\0' && board[i][0] == board[i][1] && board[i][0]==board[i][2])
                return true;
        for(int i=0;i<3;i++)
            if(board[0][i] !='\0' && board[0][i] == board[1][i] && board[0][i] == board[2][i])
                return true;
        if(board[0][0] !='\0' && board[0][0] == board[1][1] && board[1][1]==board[2][2])
            return true;
        if(board[2][0] !='\0' &&  board[2][0] ==board[1][1] && board[1][1] == board[0][2])
            return true;

        return false;
    }

    public static boolean isDraw(char[][] board){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[i][j]=='\0')
                    return false;
                return true;
    }
}
