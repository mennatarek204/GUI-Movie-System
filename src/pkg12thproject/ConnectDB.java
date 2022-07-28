package pkg12thproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {

    PreparedStatement preparedStatement = null;
    Connection con = null;
    ResultSet rs = null;

    String SQL;
    private static final String host = "jdbc:mysql://localhost/movie_list?autoReconnect=true&useSSL=false";
    private static final String usernameDB = "movie_list";
    private static final String passwordDB = "movie_list";

    public Connection ConnectDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(host, usernameDB, passwordDB);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return con;
    }
}
