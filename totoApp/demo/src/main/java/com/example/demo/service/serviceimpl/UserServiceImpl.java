package com.example.demo.service.serviceimpl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
        Get all
     */
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    /**
     *  Get by Id
     */
    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    /**
     * Post User
     */
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    /**
     * Delete User
     *
     */
    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


    /**
     * Update User
     */
    @Override
    public void updateUser(long id, User user) {
        User newUser = userRepository.findById(id).get();
        newUser.setId(user.getId());
        newUser.setEmail(user.getEmail());
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setPhone(user.getPhone());
        userRepository.save(newUser);
    }
}
