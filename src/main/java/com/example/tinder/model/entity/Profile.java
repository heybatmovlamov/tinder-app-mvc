package com.example.tinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    private Long id;
    private String username;
    private String url;

}
