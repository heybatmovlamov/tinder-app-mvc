package com.example.tinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {

    private long id;
    private String email;
    private String password;
    private boolean profilesLiked;
    private LocalDateTime loginTime;
    private Long personId;

    public UserEntity(Long id ,String email, String password ,Long personId){
        this.id = id;
        this.email= email;
        this.password = password;
        this.personId = personId;
    }
}
