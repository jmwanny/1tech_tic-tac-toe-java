package com.example.tictactoegame.model;

public abstract class AIPlayer extends Player {

    protected int row;
    protected int col;


    public AIPlayer(String mark) {
        super(mark);
    }

    public abstract void makeMove(Board board);

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getMark() {
        return mark;
    }
}
