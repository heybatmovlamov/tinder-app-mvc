package com.example.tinder.service.userService;

import com.example.tinder.model.dto.UserDto;
import com.example.tinder.model.entity.UserEntity;
import com.example.tinder.model.repository.userRepo.UserRepository;
import jakarta.servlet.http.HttpSession;
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
    private static Integer currentProfileIndex = 0 ;
    @Override
    public Optional<UserDto> login(String email, String password , HttpSession session) {
        session.setAttribute("currentProfileIndex",currentProfileIndex);
        Optional<UserEntity> userOptional = userRepository.login(email, password);
        if (userOptional.isPresent()) {
            UserEntity userEntity = userOptional.get();
            UserDto userDto = new UserDto(userEntity.getId(),userEntity.getEmail(),userEntity.getPassword());
            log.info("Login time: " + LocalDateTime.now());
            return Optional.ofNullable(userDto); // Return true to indicate successful login
        } else {
            log.warn("Login failed for email: " + email);
            return Optional.empty(); // Return false to indicate failed login
        }
    }


}
