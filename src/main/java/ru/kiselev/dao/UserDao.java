package ru.kiselev.dao;

import org.springframework.stereotype.Component;
import ru.kiselev.model.User;

import java.util.List;

@Component
public interface UserDao {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User readUser(long id);

    void deleteUser(long id);
}
