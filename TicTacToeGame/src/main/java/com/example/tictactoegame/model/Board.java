package com.example.tictactoegame.model;

public class Board {

    private String[][] board;

    public Board() {
        board = new String[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = "";
            }
        }
    }

    public boolean placeMark(int row, int col, String mark) {
        if (board[row][col].equals("")){
            board[row][col] = mark;
            return true;
        }
        return false;
    }

    public String getCell(int row, int col) {
        return board[row][col];
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (board[row][col].equals(""))
                    return false;
        return true;
    }

    public void reset() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col]= "";
            }
        }
    }

    public boolean checkWin(String mark) {

        for (int row = 0; row < 3; row++)
            if (board[row][0].equals(mark) && board[row][1].equals(mark) && board[row][2].equals(mark))
                return true;

        for (int col = 0; col < 3; col++)
            if (board[0][col].equals(mark) && board[1][col].equals(mark) && board[2][col].equals(mark))
                return true;

        if (board[0][0].equals(mark) && board[1][1].equals(mark) && board[2][2].equals(mark))
            return true;

        if (board[0][2].equals(mark) && board[1][1].equals(mark) && board[2][0].equals(mark))
            return true;
        return false;
    }

    public boolean isCellEmpty(int row, int col) {
       return board[row][col].equals("");
    }

    public boolean checkTie(){
        return isFull() && !checkWin("X") && !checkWin("O");
    }

    public void removeMark (int row, int col) {
        board[row][col] = "";
    }
}








