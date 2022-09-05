package com.example.chess;

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
        Parent root = FXMLLoader.load(getClass().getResource("chess.fxml"));
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
        stage.setScene(new Scene(root, 1000, 600));

    }

}
