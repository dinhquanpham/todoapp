package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    private long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
}
