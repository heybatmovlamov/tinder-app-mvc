package com.example.tinder.controller;

import com.example.tinder.model.dto.UserDto;
import com.example.tinder.service.userService.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginGet(@ModelAttribute UserDto userDto, Model model) {
        model.addAttribute("userDto", userDto);
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@Valid UserDto userDto, Model model, HttpSession session) {
        Optional<UserDto> loginSuccessful = userService.login(userDto.getEmail(), userDto.getPassword());
        log.info(loginSuccessful.toString());
        if (loginSuccessful.isPresent()) {
            UserDto loginSuccessDto = loginSuccessful.get();
            session.setAttribute("loggedInUser", loginSuccessDto);
            return "redirect:/like";
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }


}

