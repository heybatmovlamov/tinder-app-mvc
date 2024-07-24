package com.example.tinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {

    private Long id;
    private String email;
    private String password;
    private LocalDateTime loginTime;
    private Long profileId;

    public UserEntity(String email, String password){
        this.email= email;
        this.password = password;
    }
}