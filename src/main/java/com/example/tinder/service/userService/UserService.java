package com.example.tinder.service.userService;

import com.example.tinder.model.dto.UserDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Repository
public interface UserService {
    Optional<UserDto> login(String email , String password);
}
