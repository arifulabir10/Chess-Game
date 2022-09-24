package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registerController implements Initializable {



    public TextField firstname;
    public TextField lastname;
    public TextField email;

    @FXML
    private Button login;

    @FXML
    private PasswordField reg_pass;

    @FXML
    private Button register;

    @FXML
    private Label wrongLogin;

    @FXML
    private Label result;

    Connection con;
    PreparedStatement prepstat;

    @FXML
    void loginbutton(ActionEvent event) throws IOException, IOException {

        Stage stage =(Stage) login.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setResizable(false);
        stage.setTitle("Login Page");
        stage.setScene(new Scene(root, 650, 400));

    }

    @FXML
    void registerbutton(ActionEvent event) {
        String name1 = firstname.getText();
        String name2 = lastname.getText();
        String user_mail = email.getText();
        String pass = reg_pass.getText();


        if(name1.equals("") || name2.equals("") || user_mail.equals("") ||pass.equals("")){
            JOptionPane.showConfirmDialog(null, "These fields can't be empty");
        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/chess_game", "root", "");

                prepstat = con.prepareStatement("insert into user_info(first_name,last_name,email,password) values(?,?,?,?)");
                prepstat.setString(1, name1);
                prepstat.setString(2, name2);
                prepstat.setString(3, user_mail);
                prepstat.setString(4, pass);

                int status = prepstat.executeUpdate();

                if (status == 1) {
                    JOptionPane.showMessageDialog(null, "Record Added");
                    firstname.setText("");
                    lastname.setText("");
                    email.setText("");
                    reg_pass.setText("");
                    //   firstname.requestFocus();

                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add record");

                }

            } catch (ClassNotFoundException e) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
            } catch (SQLException e) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


