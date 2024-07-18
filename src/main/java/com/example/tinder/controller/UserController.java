package com.example.tinder.controller;

import com.example.tinder.model.dto.UserDto;
import com.example.tinder.model.entity.User;
import com.example.tinder.model.repository.UserRepository;
import com.example.tinder.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView  loginPost(@Valid UserDto userDTO,ModelAndView model) {
        User login = userService.login(userDTO.getEmail(), userDTO.getPassword());
        if (login != null) {
            model.setViewName("people-list");
            return model;
        } else {
            model.setViewName("login");
            return model;
        }
    }
}
