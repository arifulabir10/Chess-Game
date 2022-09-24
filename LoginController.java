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

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    Connection con;
    PreparedStatement prepstat;
    ResultSet result;

    @FXML
    public void loginbutton(ActionEvent event) throws ClassNotFoundException, SQLException {

        String user = username.getText();
        String pass = password.getText();

        if(user.equals("") && pass.equals("")){
            JOptionPane.showConfirmDialog(null, "These fields can't be empty");
        }
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/chess_game", "root", "");

                prepstat = con.prepareStatement("Select * from user_info where email=? and password=?");

                prepstat.setString(1, user);
                prepstat.setString(2, pass);
                result = prepstat.executeQuery();

                if(result.next()){
            //        JOptionPane.showConfirmDialog(null, "Login Success!!");
                    Stage stage =(Stage) login.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("after_login.fxml"));
                    stage.setResizable(true);
                    stage.setTitle("Dashboard");
                    stage.setScene(new Scene(root, 650, 440));

                }
                else {
                    JOptionPane.showConfirmDialog(null, "Login Failed!!");
                    username.setText("");
                    password.setText("");
                    username.requestFocus();
                }

                }
            catch (ClassNotFoundException e) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
            } catch (SQLException | IOException e) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
            }

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


