package com.example.tictactoegame.model;

import java.util.Random;

public class EasyAIPlayer extends AIPlayer {


        Random random = new Random();

        public EasyAIPlayer(String mark) {
            super(mark);
        }

        @Override
        public void makeMove(Board board) {

            if (!board.isFull()) {
                do {
                    row = random.nextInt(3);
                    col = random.nextInt(3);
                } while (!board.isCellEmpty(row, col));
                board.placeMark(row, col, this.getMark());
            }
        }



    }


