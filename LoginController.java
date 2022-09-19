package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {


    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private Button register;

    @FXML
    private TextField username;

    @FXML
    private Label wrongLogin;

    @FXML
    public void loginbutton(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        Main m = new Main();

        if(username.getText().toString().equals("ariful@gmail.com") && password.getText().toString().equals("12345678")){
            wrongLogin.setText("Success!!!");

            Stage stage =(Stage) login.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("after_login.fxml"));
            stage.setResizable(true);
            stage.setTitle("Dashboard");
            stage.setScene(new Scene(root, 650, 440));





        }
        else if(username.getText().isEmpty() || password.getText().isEmpty()) {
            wrongLogin.setText("These fields can't be empty!!");

        }
        else {
            wrongLogin.setText("Please try again");
            username.setText("");
            password.setText("");
        }

    }







    @FXML
    void registerbutton(ActionEvent event) throws IOException {

        Stage stage =(Stage) login.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage.setResizable(false);
        stage.setTitle("Registration Page");
        stage.setScene(new Scene(root, 650, 400));

    }

}


