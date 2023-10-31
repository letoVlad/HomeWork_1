package com.junit.service;

import org.example.User;
import org.example.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @BeforeEach
    void prepare() {
        System.out.println("Before" + this);
    }

    @Test
    void test() {
        var userService = new UserService();
        var users = userService.getAll();
        assertFalse(users.isEmpty(), () -> "user list");

    }

    @Test
    void userSizeIfUserAdded() {
        var userService = new UserService();
        userService.add(new User());
        userService.add(new User());

        var users = userService.getAll();
        assertEquals(2, users.size());
    }
}
