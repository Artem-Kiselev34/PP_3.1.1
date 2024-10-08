package ru.kiselev.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.kiselev.exception.UserNotFoundException;
import ru.kiselev.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User readUser(long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new UserNotFoundException("Пользователь с id " + id + " не найден");
        }
        return user;
    }

    @Override
    public void deleteUser(long id) {
        User user = readUser(id);
        if (null == user) {
            throw new NullPointerException("Пользователь не найден");
        }
        entityManager.remove(user);
    }
}