package fr.arolla.bikerental.controller;

import fr.arolla.bikerental.domain.User;
import fr.arolla.bikerental.service.UserService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    private final UserService userService = mock(UserService.class);

    @Test
    void should_get_user_informations() {
        Integer userId = 1;
        var expectedUser = new User(userId, "name", 123, true);
        when(userService.getUser(userId))
                .thenReturn(expectedUser);

        UserController sut = new UserController(userService);

        User result = sut.getUser(userId);

        assertThat(result).isEqualTo(expectedUser);
    }

    @Test
    void should_create_a_user() {
        Integer userId = 1;
        var newUser = new User(null, "name", 123, true);
        var expectedUser = new User(userId, "name", 123, true);
        when(userService.createUser(newUser))
                .thenReturn(expectedUser);

        UserController sut = new UserController(userService);

        User result = sut.createUser(newUser);

        assertThat(result).isEqualTo(expectedUser);
    }

    @Test
    void should_update_a_user() {
        Integer userId = 1;
        var user = new User(userId, "name", 123, true);
        var expectedUser = new User(userId, "name", 123, false);
        when(userService.getUser(userId))
                .thenReturn(user);
        when(userService.updateUser(expectedUser))
                .thenReturn(expectedUser);

        UserController sut = new UserController(userService);

        User result = sut.updateUser(userId, expectedUser);

        assertThat(result).isEqualTo(expectedUser);
    }

    @Test
    void should_delete_a_user() {
        Integer userId = 1;
        var user = new User(userId, "name", 123, true);
        when(userService.getUser(userId))
                .thenReturn(user);
        when(userService.deleteUser(user))
                .thenReturn(true);

        UserController sut = new UserController(userService);

        var result = sut.deleteUser(userId);

        assertThat(result).isTrue();
    }
}
