package fr.arolla.bikerental.service;

import fr.arolla.bikerental.domain.User;
import fr.arolla.bikerental.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Integer userId) {
        return userRepository.get(userId);
    }

    public User createUser(User user) {
        return userRepository.create(user);
    }

    public User updateUser(User user) {
        return userRepository.update(user);
    }

    public boolean deleteUser(User user) {
        return Optional.ofNullable(user)
                .map(userRepository::delete)
                .orElse(false);
    }
}
