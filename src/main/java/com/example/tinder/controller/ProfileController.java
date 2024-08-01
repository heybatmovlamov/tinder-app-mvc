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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/like")
    public String likeGet(Model model, HttpSession session) {
        profileService.likeGet(model, session);
        return "like-page";
    }

    @PostMapping("/like")
    public String likePost(HttpSession session, @RequestParam boolean like) {
        profileService.likePost(session, like);
        return "redirect:/like"; // Sayfayı yenilemek için yönlendirme
    }
}

