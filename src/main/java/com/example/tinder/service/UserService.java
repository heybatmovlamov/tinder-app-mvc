package com.example.tinder.service;

import com.example.tinder.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    User login(String email , String password);
}
