package com.example.chess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class registerController {

    @FXML
    private TextField email;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private Button register;

    @FXML
    private Label wrongLogin;

    @FXML
    void loginbutton(ActionEvent event) throws IOException {

        Stage stage =(Stage) login.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setResizable(false);
        stage.setTitle("Login Page");
        stage.setScene(new Scene(root, 650, 400));

    }

    @FXML
    void registerbutton(ActionEvent event) {

    }

}