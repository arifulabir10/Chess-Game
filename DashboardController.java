package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button goback;

    @FXML
    private Button manualplay;

    @FXML
    private Button playonline;

    @FXML
    private Button new_mode;

    @FXML
    void gobackbutton(ActionEvent event) throws IOException {

        Stage stage =(Stage) goback.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setResizable(false);
        stage.setTitle("Login Page");
        stage.setScene(new Scene(root, 650, 400));

    }

    @FXML
    void manualplaybutton(ActionEvent event) throws IOException {

        Stage stage =(Stage) manualplay.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setResizable(true);
        stage.setTitle("Chess Game");
        stage.setScene(new Scene(root, 800, 800));

    }

    @FXML
    void playonlinebutton(ActionEvent event) throws IOException {

        Stage stage =(Stage) playonline.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("onlinePlayer.fxml"));
        stage.setResizable(true);
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root, 1100, 600));

    }

    @FXML
    void new_modebutton(ActionEvent event) throws IOException {

        Stage stage =(Stage) new_mode.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        stage.setResizable(true);
        stage.setTitle("New Mode");
        stage.setScene(new Scene(root, 1000, 1000));

    }

}
