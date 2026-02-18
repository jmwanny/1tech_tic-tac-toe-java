package com.example.tictactoegame.model;

import java.util.Random;

public class MediumAIPlayer extends AIPlayer {
    
        Random random = new Random();

        public MediumAIPlayer(String mark) {
            super(mark);
        }

        @Override
        public void makeMove(Board board) {
         String humanMark = this.getMark().equals("X") ? "O" : "X";
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (board.isCellEmpty(r, c)) {
                        board.placeMark(r, c, this.getMark());
                        if (board.checkWin(this.getMark())) {
                            this.row = r;
                            this.col = c;
                            return;
                        }
                        board.removeMark(r, c);
                    }
                }
            }

            if(Math.random()< 0.5) {
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        if (board.isCellEmpty(r, c)) {
                            board.placeMark(r, c, humanMark);
                            boolean humanWins = board.checkWin(humanMark);
                            board.removeMark(r, c);

                            if (humanWins) {
                                board.placeMark(r, c, this.getMark());
                                row = r;
                                col = c;
                                return;
                            }
                        }
                    }
                }
            }



            if (board.isCellEmpty(1, 1)) {
                board.placeMark(1, 1, this.getMark());
                row = 1;
                col = 1;
                return;
            }

            int[][] corners = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
            for (int[] corner : corners) {
                if (board.isCellEmpty(corner[0], corner[1])) {
                    board.placeMark(corner[0], corner[1], this.getMark());
                    row = corner[0];
                    col = corner[1];
                    return;
                }
            }

            if (!board.isFull()) {
                do {
                    row = random.nextInt(3);
                    col = random.nextInt(3);
                } while (!board.isCellEmpty(row, col));
                board.placeMark(row, col, this.getMark());
            }
        }

    

    }


