package com.example.demo.service.serviceimpl;

import com.example.demo.entity.User;
import com.example.demo.model.request.RegisterRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;

@Service
public class RegisterServiceimpl implements RegisterService {

//    private PasswordEncoder passwordEncoder;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    UserRepository userRepository;


    @Override
    public String register(RegisterRequest registerRequest) {
        User newUser = new User();
        newUser.setId(registerRequest.getId());
        newUser.setEmail(registerRequest.getEmail());
        String hashPassword = passwordEncoder.encode(registerRequest.getPassword());
        newUser.setPassword(hashPassword);
//        System.out.println(passwordEncoder.matches(registerRequest.getPassword(), hashPassword));
        userRepository.save(newUser);
        System.out.println(hashPassword);
        return "Success";
    }
}
