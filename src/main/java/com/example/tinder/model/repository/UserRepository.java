package com.example.tinder.model.repository;

import com.example.tinder.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User login(String email , String password);
}
