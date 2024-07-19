package com.example.tinder.controller;

import com.example.tinder.model.dto.UserDto;
import com.example.tinder.service.userService.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("login")
    public String loginGet(@ModelAttribute UserDto userDto, Model model) {
        model.addAttribute("userDTO", userDto);
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@Valid UserDto userDto, Model model) {
        boolean loginSuccessful = userService.login(userDto.getEmail(), userDto.getPassword());
        if (loginSuccessful) {
            return "redirect:/people-list";
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }


}

