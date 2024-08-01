package com.example.tinder.service.userService;

import com.example.tinder.model.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<UserDto> login(String email , String password , HttpSession session);

}
