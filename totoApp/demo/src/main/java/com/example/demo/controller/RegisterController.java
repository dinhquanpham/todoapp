package com.example.demo.controller;

import com.example.demo.model.request.RegisterRequest;
import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest registerRequest) {
        registerService.register(registerRequest);
    }
}
