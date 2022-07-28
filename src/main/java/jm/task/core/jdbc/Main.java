package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Иван", "Иванов", (byte) 23);
        userService.saveUser("Максим", "Алишев", (byte) 34);
        userService.saveUser("Юрий", "Безруков", (byte) 43);
        userService.saveUser("Александр", "Пушкин", (byte) 102);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
