package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class onlinePlayerController {

    @FXML
    private Button goback;

    @FXML
    void gobackbutton(ActionEvent event) throws IOException {

        Stage stage =(Stage) goback.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage.setResizable(true);
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root, 1000, 600));


    }

}
