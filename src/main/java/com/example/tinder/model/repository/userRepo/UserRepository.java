package com.example.tinder.model.repository.userRepo;

import com.example.tinder.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    Optional<UserEntity> login(String email , String password);
}
