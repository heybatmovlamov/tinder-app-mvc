package com.example.tinder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    private String username;
    private String photoUrl;
    private long userId;
    private LocalDateTime time;

    public ProfileDto(String username, String photoUrl, long userId) {
        this.username = username;
        this.photoUrl = photoUrl;
        this.userId = userId;
    }
}
