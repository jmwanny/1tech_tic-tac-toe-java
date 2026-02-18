package com.example.tictactoegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static MediaPlayer mediaPlayer;
    private static boolean isMuted = false;

    @Override
    public void start(Stage stage) throws IOException {

        Font.loadFont(
                getClass().getResourceAsStream("/com/example/tictactoegame/fonts/BrickSans-Bold.otf"),
                12
        );

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/tictactoegame/menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Tic-Tac-Toe");
        stage.getIcons().add(new Image(
                getClass().getResourceAsStream("/com/example/tictactoegame/images/tic-tac-toe-logo.png")
        ));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        playBackgroundMusic();
    }

    private void playBackgroundMusic() {
        String musicPath = Objects.requireNonNull(
                getClass().getResource("/com/example/tictactoegame/audio/Tic-Tac-Toe (Music).mp3")
        ).toString();

        Media media = new Media(musicPath);
        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.30);
        mediaPlayer.play();
    }

    public static MediaPlayer getMediaPlayer(){
        return mediaPlayer;
    }

    public static void muteSound() {
        isMuted = !isMuted;
        if (mediaPlayer != null) {
            mediaPlayer.setMute(isMuted);
        }
    }

    public static boolean isMuted() {
        return isMuted;
    }

    public static void main(String[] args) {
        launch();
    }
}
