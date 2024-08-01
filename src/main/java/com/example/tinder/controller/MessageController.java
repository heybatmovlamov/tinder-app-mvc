package com.example.tinder.controller;

import com.example.tinder.model.dto.ProfileDto;
import com.example.tinder.model.dto.UserDto;
import com.example.tinder.model.repository.messageRepo.MessageRepository;
import com.example.tinder.service.messageService.MessageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Controller
public class MessageController {
    public final MessageService messageService;
    @GetMapping("/message")
    public String getMessage(HttpSession session, Model model) {
        UserDto userDto = (UserDto) session.getAttribute("loggedInUser");
        if (userDto != null) {
            Long id = userDto.getId();
            log.info(id.toString());
            String messages = messageService.getMessage(id);
            model.addAttribute("messages", messages);
        }
        return "chat";
    }

    @PostMapping("/message")
    public String sendMessage(@RequestParam String message, HttpSession session) {
        ProfileDto profileDto = (ProfileDto) session.getAttribute("profileDto");
        if (profileDto != null) {
            Long id = profileDto.getUserId();
            log.info(id.toString());
            messageService.sendMessage(message, id);
        }
        return "redirect:/message";
    }



}
