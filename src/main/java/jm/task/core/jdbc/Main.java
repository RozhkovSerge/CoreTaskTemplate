package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

//        userDao.dropUsersTable();
        userDao.saveUser("Oleg", "Sidorov", (byte) 23);
        userDao.saveUser("Ivan", "Petrov", (byte) 32);
        userDao.saveUser("Sergey", "Ivanov", (byte) 31);
        userDao.saveUser("Anton", "Smirnov", (byte) 44);

        userDao.removeUserById(2);
    }
}
