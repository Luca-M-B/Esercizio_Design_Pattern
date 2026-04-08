package service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/pizzeria_itconsulting";
    private static final String USER = "root";
    private static final String PASS = "root";

    private DBConnection() throws Exception {
        this.connection = DriverManager.getConnection(URL, USER, PASS);
    }

    public static DBConnection getInstance() throws Exception {
        if (instance == null) {
            synchronized(DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}