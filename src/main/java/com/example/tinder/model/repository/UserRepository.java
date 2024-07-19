package com.example.tinder.model.repository;

import com.example.tinder.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    UserEntity login(String email , String password);
}
