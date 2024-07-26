package com.example.tinder.service.profileService;

import com.example.tinder.model.dto.ProfileDto;
import com.example.tinder.model.entity.ProfileEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public interface ProfileService {
    List<ProfileEntity> getAllUsers ();

    void likeOrDislike(boolean like, long userId, long likedUserId);

    void likeGet(Model model, HttpSession session);

    void likePost(HttpSession session ,boolean like);
}
