package com.example.demo.service;


import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();

    public User getUserById(long Id);

    public void createUser(User user);

    public void updateUser(long id, User user);

    public void deleteUser(long id);
}
