package com.example.tinder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDto {

    private String username;
    private String photoUrl;

    public PeopleDto(String username, String photoUrl) {
        this.username = username;
        this.photoUrl = photoUrl;
    }

    private LocalDateTime time;
}
