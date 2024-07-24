package com.example.tinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntity {

    private long id;
    private String username;
    private String photoUrl;
    private boolean like;
    private long userId;

    public ProfileEntity(long id, String username, String photoUrl ,long userId) {
        this.id = id;
        this.username = username;
        this.photoUrl = photoUrl;
        this.userId = userId;
    }
}
