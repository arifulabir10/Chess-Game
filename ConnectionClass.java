package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection connection;
    public  Connection getConnection(){


        String dbName="chess_game";
        String userName="root";


        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }

}