package com.example.tinder.service;

import com.example.tinder.model.dto.UserDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
public interface UserService {
    void login(String email , String password);
}
