package com.example.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.show();
    }



    public static void main(String[] args) {

        launch();
    }
}