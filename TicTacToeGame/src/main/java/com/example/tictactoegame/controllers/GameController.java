package com.example.tictactoegame.controllers;
import com.example.tictactoegame.Main;
import com.example.tictactoegame.model.*;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GameController {

    private Game game;

    private MenuController menu;

    public void setMenu(MenuController menu){
        this.menu = menu;
    }

    private int p1Score = 0;
    private int p2Score = 0;
    private int tie = 0;
    private boolean gameEnded = false;

    @FXML
    private ImageView muteIcon;

    @FXML
    public void initialize() {

        updateIcon();
    }

    @FXML
    private Button cell00,cell01,cell02;

    @FXML
    private Button cell10, cell11, cell12;

    @FXML
    private Button cell20, cell21, cell22;

    @FXML
    private Label labelTurn;

    @FXML
    private Label player1Label, player2Label, tieLabel, winnerLabel;

    @FXML
    private Pane winnerPane;

    @FXML
    private Button menuButton;

    @FXML
    private Button muteButton;


    private Button [][] buttons;


    private void initializeLabelTurn() {
        setplayerTurnLabel();
    }

    public void setGame (Game game){
        this.game = game;
        initializeBoard();
    }
    @FXML
    private void initializeBoard(){
        winnerPane.setVisible(false);
        updateIcon();
        buttons = new Button[][]{
                {cell00, cell01, cell02},
                {cell10, cell11, cell12},
                {cell20, cell21, cell22 }
        };

        initializeLabelTurn();

        for(int row=0; row<3; row++) {
            for (int col = 0; col < 3; col++) {
                Button btn = buttons[row][col];
                btn.setText("");
                btn.setStyle("-fx-text-fill:#00EAFF; -fx-background-color: #1E1E1E; -fx-border-color: #00EAFF; -fx-border-width: 2; -fx-background-radius: 10; -fx-border-radius: 10; -fx-font-size: 36; -fx-font-weight:bold; -fx-font-family: 'Segoe UI Black';");
                int r = row;
                int c = col;
                btn.setOnAction(e -> handleCellClick(r, c));
            }
        }
    }

    private void handleCellClick(int row, int col) {
        if (game.getCurrentPlayer() instanceof HumanPlayer && game.isCellEmpty(row, col))  {
            game.makeMove(row, col);
            buttons[row][col].setText(game.getCurrentPlayer().getMark());
            buttons[row][col].setMouseTransparent(true);
            showWinner();
            game.switchTurn();
            setplayerTurnLabel();
    }
        if (game.getCurrentPlayer() instanceof AIPlayer aiPlayer) {

             handleAITurn(aiPlayer);

        }}


    private void setplayerTurnLabel() {
        if(game.getCurrentPlayer() == game.getPlayer1()){
            labelTurn.setText(menu.isPlayer1X() ? "X TURN" : "O TURN" );
        } else {
            labelTurn.setText(menu.isPlayer1X() ? "O TURN" : "X TURN" );
        }
    }


    private void showWinner(){
        if(gameEnded) return;

        if(game.isThereWinner()){
                String winnerName = String.valueOf(game.getWinner().getMark());
                winnerPane.setVisible(true);
                winnerLabel.setText(winnerName + " wins!");
                handleScore();
                gameEnded = true;
            return;
        }
        if (game.isitTie()){
            winnerPane.setVisible(true);
            winnerLabel.setText("TIE!");
            handleScore();
            gameEnded = true;
        }
    }

    private void handleScore() {
        if (game.getWinner() == game.getPlayer1()) {
            p1Score++;
            player1Label.setText(String.valueOf(p1Score));
            return;
        }
        if(game.getWinner() == game.getPlayer2()){
            p2Score++;
            player2Label.setText(String.valueOf(p2Score));
            return;
        }

        if (game.isitTie()) {
            tie++;
            tieLabel.setText(String.valueOf(tie));
        }
    }

    private void handleAITurn(AIPlayer aiPlayer){

        if(gameEnded || game.isGameOver()){
            return;
        }

        disableBoard();
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event -> {
            aiPlayer.makeMove(game.getBoard());

            int aiRow = aiPlayer.getRow();
            int aiCol = aiPlayer.getCol();
            buttons[aiRow][aiCol].setText(aiPlayer.getMark());
            buttons[aiRow][aiCol].setMouseTransparent(true);
            showWinner();
            game.switchTurn();
            setplayerTurnLabel();
            enableBoard();
        });
        delay.play();

    }


    @FXML
    private void resetGame (){
        gameEnded = false;
        game.resetGame();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                setplayerTurnLabel();
                buttons[row][col].setMouseTransparent(false);
            }
        }

    }
    @FXML
    private void continueGame(){
        resetGame();
        winnerPane.setVisible(false);
    }

    @FXML
    private void mainMenu(){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tictactoegame/menu.fxml"));
                Scene scene = new Scene(loader.load());

                Stage stage = (Stage) menuButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    private void disableBoard() {
        for (Button[] row : buttons) {
            for (Button btn : row) {
                btn.setMouseTransparent(true);
            }
        }
    }

    private void enableBoard() {
        for (Button[] row : buttons) {
            for (Button btn : row) {
                if (btn.getText().isEmpty()) {
                    btn.setMouseTransparent(false);
                }
            }
        }
    }

    public void muteSound(){
        Main.muteSound();
        updateIcon();
    }

    public void updateIcon(){
        String img = Main.isMuted() ?
                "/com/example/tictactoegame/images/volume-mute.png" :
                "/com/example/tictactoegame/images/volume.png";

        muteIcon.setImage(new Image(getClass().getResourceAsStream(img)));
    }

}




