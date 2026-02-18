package com.example.tictactoegame.model;

public abstract class Player {

    protected String mark;

    public Player (String mark){
        this.mark = mark;
    }

    public String getMark () {
        return mark;
    }


}
