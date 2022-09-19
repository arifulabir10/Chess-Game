package sample;


import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbController {
    public TextField textField;
    public Label textLabel;
    public TextField first_name;
    public TextField last_name;
    public TextField email;
    public TextField password;

    public Label isConnected;


    public void button(ActionEvent actionEvent) throws SQLException {
        textLabel.setText(textField.getText());
        System.out.println("Program is running");
    }

    public void login(ActionEvent actionEvent) throws SQLException {

        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();



            String sql= "INSERT INTO user_info VALUES ('"+first_name.getText()+" "+last_name.getText()+" "+email.getText()+" "+password.getText()+" ')";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);





    }
}
