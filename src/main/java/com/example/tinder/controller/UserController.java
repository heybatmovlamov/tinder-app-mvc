package com.example.tinder.controller;

import com.example.tinder.model.dto.UserDto;
import com.example.tinder.model.entity.UserEntity;
import com.example.tinder.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("login")
    public String loginGet(@ModelAttribute UserDto userDto, Model model) {
        model.addAttribute("userDTO", userDto);
        return "login";
    }

    @PostMapping("login")
    public void loginPost(@Valid UserDto userDTO) {
        userService.login(userDTO.getEmail(), userDTO.getPassword());
    }
}

