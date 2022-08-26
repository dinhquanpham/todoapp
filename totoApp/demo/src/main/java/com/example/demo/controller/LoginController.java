package com.example.demo.controller;

import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.respone.LoginRespone;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public LoginRespone login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

    @PostMapping("/logout")
    public String logout(LoginRespone loginRespone){
        return loginService.logout(loginRespone);
    }
}
