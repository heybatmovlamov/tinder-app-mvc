package com.example.tinder.service.userService;

import com.example.tinder.model.dto.UserDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
public interface UserService {
    boolean login(String email , String password);
}
