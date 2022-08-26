package com.example.demo.service.serviceimpl;

import com.example.demo.entity.User;
import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.respone.LoginRespone;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    List<String> tokenList = new ArrayList<String>();

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public LoginRespone login(LoginRequest loginRequest) {
        User newUser = userRepository.findUserByEmail(loginRequest.getEmail());
        LoginRespone loginRespone = new LoginRespone();
        System.out.println(bCryptPasswordEncoder.matches(loginRequest.getPassword(),newUser.getPassword()));
        String token = UUID.randomUUID().toString();
        if (bCryptPasswordEncoder.matches(loginRequest.getPassword(),newUser.getPassword())) {
            newUser.setPassword(loginRequest.getPassword());
            loginRespone.setUser(newUser);
            loginRespone.setNotification("Login Succesfull!");
            loginRespone.setToken(token);
            tokenList.add(token);
            return loginRespone;
        }
        loginRespone.setNotification("Login Fail!");
        return loginRespone;
    }
    public String logout(LoginRespone loginRespone) {
        tokenList.remove(loginRespone.getToken());
        return "Logout Succesfully!";
    }
}
