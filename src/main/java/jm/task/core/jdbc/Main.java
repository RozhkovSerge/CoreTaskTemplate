package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Oleg", "Sedov", (byte) 23);
        userService.saveUser("Ivan", "Petrov", (byte) 32);
        userService.saveUser("Sergey", "Ivanov", (byte) 31);
        userService.saveUser("Anton", "Smirnov", (byte) 44);
        userService.getAllUsers();

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}
