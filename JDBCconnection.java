package sample;

import java.sql.*;

public class JDBCconnection {
    public static void main(String[] args) throws SQLException {

        try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chess_game", "root", "root" );

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from user_info");

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
}
