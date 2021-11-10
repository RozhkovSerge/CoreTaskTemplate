package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class Util {
    // реализуйте настройку соеденения с БД
    private static Util instance;
    private static SessionFactory sessionFactory;
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/db_1";
    private final static String USER = "db_user";
    private final static String PASSWORD = "db_user";
    private final static String DIALECT = "org.hibernate.dialect.MySQL5Dialect";
    private final static String HBM2DDL_AUTO = "create-drop";

    public Util() {
    }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.URL, URL);
                settings.put(Environment.USER, USER);
                settings.put(Environment.PASS, PASSWORD);
                settings.put(Environment.DRIVER, DRIVER);
                settings.put(Environment.DIALECT, DIALECT);
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                settings.put(Environment.SHOW_SQL, true);

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return sessionFactory;
    }
}
