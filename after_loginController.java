package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class after_loginController {

    @FXML
    private Button dashboard;

    @FXML
    private Button logout;

    @FXML
    void dashboardbutton(ActionEvent event) throws IOException {

        Stage stage =(Stage) dashboard.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage.setResizable(true);
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root, 1000, 600));

    }

    @FXML
    void logoutbutton(ActionEvent event) throws IOException {
        Stage stage =(Stage) logout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setResizable(false);
        stage.setTitle("Login Page");
        stage.setScene(new Scene(root, 650, 400));

    }

}
