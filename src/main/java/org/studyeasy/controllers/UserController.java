package org.studyeasy.controllers;

import org.studyeasy.models.User;
import org.studyeasy.services.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")

public class UserController {

    private final UserService userService = new UserService();

    // CREATE
    @PostMapping
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User added successfully!";
    }

    // READ
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        userService.updateUser(id, user);
        return "User updated successfully!";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User deleted successfully!";
    }
}



//public class UserController {
//    private final UserService userService = new UserService();
//
//    public void displayAllUsers() {
//        List<User> users = userService.getAllUsers();
//        for (User user : users) {
//            System.out.println(", Username: " + user.getUsername() + ", Password: " + user.getPassword());
//        }
//    }
//}