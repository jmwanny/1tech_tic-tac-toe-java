package com.example.tictactoegame.controllers;
import com.example.tictactoegame.Main;
import com.example.tictactoegame.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import com.example.tictactoegame.model.HumanPlayer;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class MenuController {

    @FXML
    private ToggleButton btnX, btnO;
    private String player1mark = "X";

    @FXML
    private ImageView muteIcon;

    public String getPlayer1mark(){
        return player1mark;
    }

    @FXML
    public void initialize() {
        btnX.setSelected(true);
        btnO.setSelected(false);

        updateIcon();
    }

    @FXML
    public void selectX() {
        btnX.setSelected(true);
        btnO.setSelected(false);
        player1mark = "X";
        System.out.println("Player selects X!");
    }

    @FXML
    public void selectO() {
        btnO.setSelected(true);
        btnX.setSelected(false);
        player1mark = "O";
        System.out.println("Player selects O!");
    }



    public boolean isPlayer1X(){
        return player1mark.equals("X");
    }

    @FXML
    private void handlePvP(ActionEvent event) {
        try {
            String player2mark = player1mark.equals("X") ? "O" : "X";
            HumanPlayer player1 = new HumanPlayer(player1mark);

            HumanPlayer player2 = new HumanPlayer(player2mark);
            Game game = new Game(player1, player2);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tictactoegame/game.fxml"));
            Scene scene = new Scene(loader.load());
            GameController controller = loader.getController();
            controller.setMenu(this);
            controller.setGame(game);
            controller.updateIcon();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @FXML
    private void handleAI(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tictactoegame/AILevels.fxml"));
            Scene scene = new Scene(loader.load());
            AILevelsController controller = loader.getController();
            controller.setMenu(this);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleHowTo(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tictactoegame/howTo.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
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