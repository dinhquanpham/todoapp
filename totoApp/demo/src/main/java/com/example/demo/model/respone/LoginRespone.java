package com.example.demo.model.respone;

import com.example.demo.entity.User;
import lombok.Data;

@Data
public class LoginRespone {
    private User user;
    private String notification;
    private String token;
}
