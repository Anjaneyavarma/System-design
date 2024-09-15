package LLD.TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private Deque<String> players;
    private String board[][];

    public Main(){

    }

    public Main(String[][] board){
        this.board = board;
    }

    public void initializeGame(int boardSize){
        players = new LinkedList<>();
        board = new String[boardSize][boardSize];
        players.add("X");
        players.add("O");
    }

    public int getFreeCells(String board[][]) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean insertPlayer(int row, int column, String board[][], String playerTurn){
        if(board[row][column]!=null){
            return false;
        }
        board[row][column] = playerTurn;
        return true;
    }

    public void printBoard(String board[][]){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("|");
                if(board[i][j] !=null){
                    System.out.print(board[i][j]+" ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public boolean winner(String board[][], int row, int column, String playerTurn){
        boolean rowEqual = true;
        boolean columnEqual = true;
        boolean daignolEqual = true;
        boolean antiDaignolEqual = true;

        //row check
        for(int i=0;i<board.length;i++){
            if(board[row][i]==null || board[row][i]!=playerTurn){
                rowEqual = false;
                break;
            }
        }
        //column check
        for(int i=0;i<board.length;i++){
            if(board[i][column]==null || board[i][column]!=playerTurn){
                columnEqual =  false;
                break;
            }
        }
        //daignol check
        for(int i=0, j=0; i<board.length;i++,j++) {
            if (board[i][j] == null || board[i][j] != playerTurn) {
                daignolEqual = false;
                break;
            }
        }
        //anti-daignol check
        for(int i=0, j=board.length-1; i<board.length;i++,j--) {
            if (board[i][j] == null || board[i][j] != playerTurn) {
                antiDaignolEqual = false;
                break;
            }
        }
        return rowEqual || columnEqual || daignolEqual || antiDaignolEqual;
    }

    public String startGame(){
        boolean freeCells = true;
        while(freeCells){
            String playerTurn = players.removeFirst();
            printBoard(board);
            if(getFreeCells(board)<=0){
                freeCells = false;
                continue;
            }
            System.out.println(playerTurn + " - Enter row and column");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] rowColumn = s.split(",");
            int row = Integer.valueOf(rowColumn[0]);
            int column = Integer.valueOf(rowColumn[1]);

            if(row> board.length && column> board.length){
                System.out.println("Please choose row and column within "+board.length);
                players.addFirst(playerTurn);
                continue;
            }

            boolean validInsertion = insertPlayer(row, column, board, playerTurn);
            if(!validInsertion){
                System.out.println("This position was already filled");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean isPlayerWinner = winner(board, row, column, playerTurn);
            if(isPlayerWinner){
                printBoard(board);
                return "winner is "+playerTurn;
            }
        }
        return "TIE";
    }

    public static void main(String[] args){
        Main game = new Main();
        game.initializeGame(3);
        System.out.println(game.startGame());
    }

}
