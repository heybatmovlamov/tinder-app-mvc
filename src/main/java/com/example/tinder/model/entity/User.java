package com.example.tinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Long id;
    private String email;
    private String password;
    private String photo;
    private LocalDateTime loginTime;

    public User(String email,String password){
        this.email= email;
        this.password = password;
    }
}