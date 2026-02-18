module com.example.tictactoegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens com.example.tictactoegame to javafx.fxml;
    opens com.example.tictactoegame.controllers to javafx.fxml;
    exports com.example.tictactoegame;
}