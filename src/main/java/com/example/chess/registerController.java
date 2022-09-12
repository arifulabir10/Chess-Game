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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
    private Label result;

    @FXML
    void loginbutton(ActionEvent event) throws IOException {

        Stage stage =(Stage) login.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setResizable(false);
        stage.setTitle("Login Page");
        stage.setScene(new Scene(root, 650, 400));

    }

    @FXML
    void registerbutton(ActionEvent event) throws SQLException {

        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        String first_name = firstname.getText();
        String last_name = lastname.getText();
        String email_val = email.getText();
        String password_val = password.getText();


        String insertFields = "INSERT INTO `user_info` (first_name,last_name,email_val,password_val) VALUES ( '";
        String insertValues = first_name + "','" + last_name + "','" + email_val + "','" + password_val + "')";
        String insertToRegister = insertFields + insertValues;

//        String sql = "INSERT INTO `user_info` (' "+ firstname.getText()+lastname.getText()+ email.getText()+ password.getText()+ " ')";
//        Statement statement = connection.createStatement();
//
//        statement.executeUpdate(sql);

        result.setText("Successful!!!");
    }

}

