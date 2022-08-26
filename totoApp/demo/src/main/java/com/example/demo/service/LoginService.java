package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.respone.LoginRespone;

public interface LoginService {
    LoginRespone login(LoginRequest loginRequest);
    String logout(LoginRespone loginRespone);
}
