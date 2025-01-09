package org.studyeasy.controllers;

import org.studyeasy.models.User;
import org.studyeasy.services.UserService;

import java.util.List;

public class UserController {
    private final UserService userService = new UserService();

    public void displayAllUsers() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(", Username: " + user.getUsername() + ", Password: " + user.getPassword());
        }
    }
}
