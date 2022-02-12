package fr.arolla.bikerental.repository;

import fr.arolla.bikerental.domain.User;

public interface UserRepository {
    User get(Integer userId);

    User create(User user);

    User update(User user);

    boolean delete(User user);
}
