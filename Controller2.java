package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class Controller2 {

    @FXML
    GridPane chessBoard;

    public void initialize(){

        // Themes are Coral, Dusk, Wheat, Marine, Emerald, Sandcastle

        Game2 game = new Game2(chessBoard, "Coral");

    }
}
