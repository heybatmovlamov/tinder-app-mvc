package com.example.tinder.service;

import com.example.tinder.exception.PasswordOrEmailNotCorrectException;
import com.example.tinder.model.entity.User;
import com.example.tinder.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User login(String email, String password) {
        User login = userRepository.login(email, password);
        login.setLoginTime(LocalDateTime.now());
        if (login.getEmail() !=null && login.getPassword() != null) {
            return login;
        }else {
            throw new PasswordOrEmailNotCorrectException("email or password not correct !");
        }
    }

}
