package com.example.tinder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDto {

    private String email;
    private String password;
    private String photo;
    private LocalDateTime loginTime;
}
