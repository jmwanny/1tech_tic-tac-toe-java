package com.example.tictactoegame.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HowToController {

    @FXML
    private Button menuButton;

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


}
