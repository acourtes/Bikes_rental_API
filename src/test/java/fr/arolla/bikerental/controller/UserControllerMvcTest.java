package fr.arolla.bikerental.controller;

import fr.arolla.bikerental.domain.User;
import fr.arolla.bikerental.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@ExtendWith(SpringExtension.class)
public class UserControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void should_get_user_informations() throws Exception {
        Integer userId = 1;
        var user = new User(userId, "name", 123, true);
        when(userService.getUser(userId)).thenReturn(user);

        mockMvc.perform(get("/api/v1/users/{id}", userId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(TestUtils.asJsonString(user)));
    }

    @Test
    void should_create_a_user() throws Exception {
        var userToCreate = new User(null, "name", 123, true);
        var createdUser = new User(1, "name", 123, true);
        when(userService.createUser(userToCreate)).thenReturn(createdUser);

        mockMvc.perform(post("/api/v1/users")
                        .content(TestUtils.asJsonString(userToCreate))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(TestUtils.asJsonString(createdUser)));
    }

    @Test
    void should_update_user() throws Exception {
        var userId = 1;
        var userToUpdate = new User(userId, "name", 123, true);
        var updatedUser = new User(userId, "name", 12345, false);
        when(userService.getUser(userId)).thenReturn(userToUpdate);
        when(userService.updateUser(userToUpdate)).thenReturn(updatedUser);

        mockMvc.perform(put("/api/v1/users/{userId}", userId)
                        .content(TestUtils.asJsonString(userToUpdate))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(TestUtils.asJsonString(updatedUser)));
    }

    @Test
    void should_delete_user() throws Exception {
        var userId = 1;
        var userToDelete = new User(userId, "name", 123, true);
        when(userService.getUser(userId)).thenReturn(userToDelete);
        when(userService.deleteUser(userToDelete)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/users/{userId}", userId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
