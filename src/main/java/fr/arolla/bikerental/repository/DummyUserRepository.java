package fr.arolla.bikerental.repository;

import fr.arolla.bikerental.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DummyUserRepository implements UserRepository{
    private final HashMap<Integer, User> userById = new HashMap<>();
    private int index = 1;

    @Override
    public User get(Integer userId) {
        return userById.get(userId);
    }

    @Override
    public User create(User user) {
        var newUser = new User(index, user.name(), user.accessCardId(), user.hasActivePaymentCard());
        return userById.put(index++, newUser);
    }

    @Override
    public User update(User user) {
        return userById.put(user.userId(), user);
    }

    @Override
    public boolean delete(User user) {
        var removedUser = userById.remove(user.userId());
        return removedUser != null;
    }
}
