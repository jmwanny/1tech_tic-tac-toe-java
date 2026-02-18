package com.example.tictactoegame.model;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Player p1, Player p2) {
        this.board = new Board();
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = player1;
    }

    public boolean makeMove(int row, int col) {
        if (isCellEmpty(row, col)) {
            board.placeMark(row, col, currentPlayer.getMark());
            return true;
        }
        return false;
    }

    public void switchTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean isGameOver() {
        return board.checkWin(currentPlayer.getMark()) || board.isFull();
    }

    public Player getWinner() {
        if (board.checkWin(player1.getMark())) {
            return player1;
        }
        if (board.checkWin(player2.getMark())) {
            return player2;
        }
        return null;
    }

    public void resetGame() {
        board.reset();
        currentPlayer = player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isCellEmpty(int row, int col) {
        return board.isCellEmpty(row, col);
    }

    public boolean isThereWinner() {
        if (getWinner() != null) {
            System.out.println("WINNER: " + getWinner());
            return true;
        } else {
            return false;
        }
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }
    public boolean isitTie(){
        return board.checkTie();
    }

    public Board getBoard(){
        return board;
    }

    public void setCurrentPlayer(Player currentPlayer){
        this.currentPlayer = currentPlayer;
    }

    public boolean isCurrentPlayer1() {
        if (currentPlayer == player1) {
            return true;
        } else {
            return false;
        }
    }
}

