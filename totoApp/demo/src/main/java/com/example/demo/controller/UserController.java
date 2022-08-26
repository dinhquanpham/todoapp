package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<User> getAll() {
        return userService.getAllUser();
    }

    @GetMapping("/get/{id}")
    public User getById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/save")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
