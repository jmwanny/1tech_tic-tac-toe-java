package com.example.tictactoegame.controllers;
import com.example.tictactoegame.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class AILevelsController {

    private MenuController menu;

    public void setMenu(MenuController menu){
        this.menu = menu;
    }

    @FXML
    private void handleEasy(ActionEvent event){
        try{
            String player2mark = menu.isPlayer1X() ? "O": "X";
            Player player1 = new HumanPlayer(menu.getPlayer1mark());

            Player player2 = new EasyAIPlayer(player2mark);
            Game game = new Game (player1, player2);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tictactoegame/game.fxml"));
            Scene scene = new Scene(loader.load());
            GameController controller = loader.getController();
            controller.setMenu(menu);
            controller.setGame(game);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void handleMedium(ActionEvent event){
        try{
            String player2mark = menu.isPlayer1X() ? "O": "X";
            Player player1 = new HumanPlayer(menu.getPlayer1mark());

            Player player2 = new MediumAIPlayer(player2mark);
            Game game = new Game (player1, player2);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tictactoegame/game.fxml"));
            Scene scene = new Scene(loader.load());
            GameController controller = loader.getController();
            controller.setMenu(menu);
            controller.setGame(game);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    private void handleHard(ActionEvent event){
        try{
            String player2mark = menu.isPlayer1X() ? "O": "X";
            Player player1 = new HumanPlayer(menu.getPlayer1mark());

            Player player2 = new HardAIPlayer(player2mark);
            Game game = new Game (player1, player2);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tictactoegame/game.fxml"));
            Scene scene = new Scene(loader.load());
            GameController controller = loader.getController();
            controller.setMenu(menu);
            controller.setGame(game);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
