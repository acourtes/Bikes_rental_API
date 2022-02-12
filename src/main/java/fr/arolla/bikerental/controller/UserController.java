package fr.arolla.bikerental.controller;

import fr.arolla.bikerental.domain.User;
import fr.arolla.bikerental.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable("userId") Integer userId,
                           @RequestBody User updatedUser) {
        var currentUser = userService.getUser(userId);
        var upToDateUser = new User(currentUser.userId(), updatedUser.name(), updatedUser.accessCardId(), updatedUser.hasActivePaymentCard());

        return userService.updateUser(upToDateUser);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable("userId") Integer userId) {
        var user = userService.getUser(userId);

        return userService.deleteUser(user);
    }
}
