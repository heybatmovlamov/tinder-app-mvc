package com.example.tinder.service.userService;

import com.example.tinder.model.entity.UserEntity;
import com.example.tinder.model.repository.userRepo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public boolean login(String email, String password) {
        Optional<UserEntity> userOptional = userRepository.login(email, password);

        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            user.setLoginTime(LocalDateTime.now());
            log.info("Login time: " + user.getLoginTime());
            return true; // Return true to indicate successful login
        } else {
            log.warn("Login failed for email: " + email);
            return false; // Return false to indicate failed login
        }
    }

}
