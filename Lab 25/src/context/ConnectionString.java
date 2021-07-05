package context;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class ConnectionString {
    protected static Connection init() throws SQLServerException {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("Java25");
        dataSource.setPortNumber(1433);
        dataSource.setUser("sa");
        dataSource.setPassword("10101976Dad@");
        System.out.println("Connection string");
        return dataSource.getConnection();
    }
}
