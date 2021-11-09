package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    // реализуйте настройку соеденения с БД
    private static Connection connection;
    private static Util instance;
    private final static String URL = "jdbc:mysql://localhost:3306/db_1";
    private final static String USER = "db_user";
    private final static String PASSWORD = "db_user";

    private Util() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Util getInstance() throws SQLException {
        if(instance == null) {
            instance = new Util();
        } else if (instance.getConnection().isClosed()) {
            instance = new Util();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
