package sample;

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



    public TextField first_name;
    public TextField last_name;
    public TextField email;

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
    void loginbutton(ActionEvent event) throws IOException, IOException {

        Stage stage =(Stage) login.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setResizable(false);
        stage.setTitle("Login Page");
        stage.setScene(new Scene(root, 650, 400));

    }

    @FXML
    void registerbutton(ActionEvent event) throws SQLException {


//        ConnectionClass connectionClass=new ConnectionClass();
//        Connection connection=connectionClass.getConnection();
//
//
//
//        String sql= "INSERT INTO user_info VALUES ('"+first_name.getText()+" ')";
//
//        Statement statement = connection.createStatement();
//        statement.executeUpdate(sql);
//
//        result.setText("Successful!!!");


        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        String firstname = first_name.getText();
        String lastname = last_name.getText();
        String emailval = email.getText();
        String passwordval = password.getText();


        String sql = "INSERT INTO `user_info` (' "+ first_name.getText()+last_name.getText()+ email.getText()+ password.getText()+ " ')";
        Statement statement = connection.createStatement();

//        String insertFields = "INSERT INTO `user_info` (first_name,last_name,email_val,password_val) VALUES ( '";
//        String insertValues = firstname + "','" + lastname + "','" + emailval + "','" + passwordval + "')";
//        String insertToRegister = insertFields + insertValues;



        statement.executeUpdate(sql);
        result.setText("Successful!!!");


    }

}


