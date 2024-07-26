package com.example.tinder.controller;

import com.example.tinder.model.dto.ProfileDto;
import com.example.tinder.model.dto.UserDto;
import com.example.tinder.model.entity.ProfileEntity;
import com.example.tinder.service.profileService.ProfileService;
import com.example.tinder.service.userService.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
@Slf4j
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/like")
    public String likeGet(Model model, HttpSession session) {
        profileService.likeGet(model, session);
        return "like-page";
    }


    @PostMapping("/like")
    public String likePost(HttpSession session, boolean like) {
        profileService.likePost(session,like);
        return "like-page";
    }
}

