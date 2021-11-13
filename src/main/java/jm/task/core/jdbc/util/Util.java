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

    public Util() {
    }

    public static Util getInstance() {
        try{
            if (instance == null) {
                instance = new Util();
                connection = instance.getConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
