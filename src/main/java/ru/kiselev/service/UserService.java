package ru.kiselev.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kiselev.model.User;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();

    User readUser(long id);

    void deleteUser(long id);

    void updateUser(User user);

    void createUser(User user);
}
