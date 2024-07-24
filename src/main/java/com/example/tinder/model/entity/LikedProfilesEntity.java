package com.example.tinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikedProfilesEntity {

    private Long id ;
    private Long userId;
    private Long likeUserId;

}
