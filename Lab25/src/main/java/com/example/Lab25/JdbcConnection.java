package com.example.Lab25;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        String ip = "localhost";
        String Classes = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String database = "Java25";
        String username = "sa";
        String password = "10101976Dad@";
        String url = "jdbc:sqlserver://"+ip+";databaseName="+database;
        Connection connection;
        Class.forName(Classes);
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Database Connection Success!");
        return connection;


    }
}
