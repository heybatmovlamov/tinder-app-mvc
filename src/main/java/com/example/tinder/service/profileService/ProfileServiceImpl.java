package com.example.tinder.service.profileService;

import com.example.tinder.model.dto.ProfileDto;
import com.example.tinder.model.dto.UserDto;
import com.example.tinder.model.entity.ProfileEntity;
import com.example.tinder.model.repository.profileRepo.ProfileRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    public static int currentProfileIndex = 0;
    @Override
    public List<ProfileEntity> getAllUsers() {
        return profileRepository.getAllUsers(); // Tüm kullanıcıları almak için repository metodunu kullanın
    }

    @Override
    public void likeOrDislike(boolean like, long userId, long likedUserId) {
        profileRepository.likeOrDislike(like, userId, likedUserId);
    }

    @Override
    public void likeGet(Model model, HttpSession session) {
        List<ProfileEntity> allUsers = getAllUsers();

        Integer currentProfileIndex = (Integer) session.getAttribute("currentProfileIndex");
        if (currentProfileIndex == null || currentProfileIndex >= allUsers.size()) {
            currentProfileIndex = 0;
        }

        ProfileEntity entity = allUsers.get(currentProfileIndex);
        ProfileDto profileDto = new ProfileDto(entity.getUsername(), entity.getPhotoUrl(), entity.getUserId());
        session.setAttribute("profileDto", profileDto);

        UserDto loggedInUser = (UserDto) session.getAttribute("loggedInUser");

        if (profileDto.getUserId() == loggedInUser.getId()) {
            // Eğer profil, giriş yapmış kullanıcıya aitse, bir sonraki profili göster
            currentProfileIndex++;
            session.setAttribute("currentProfileIndex",currentProfileIndex);
            if (currentProfileIndex >= allUsers.size()) {
                currentProfileIndex = 0;
            }
            entity = allUsers.get(currentProfileIndex);
            profileDto = new ProfileDto(entity.getUsername(), entity.getPhotoUrl(), entity.getUserId());
            session.setAttribute("profileDto", profileDto);
        }
        model.addAttribute("username", profileDto.getUsername());
        model.addAttribute("photoUrl", profileDto.getPhotoUrl());
    }

    @Override
    public void likePost(HttpSession session, boolean like) {
        UserDto loggedInUser = (UserDto) session.getAttribute("loggedInUser");
        ProfileDto profileDto = (ProfileDto) session.getAttribute("profileDto");

        if (loggedInUser != null && profileDto != null && loggedInUser.getId() != profileDto.getUserId()) {
            likeOrDislike(like, loggedInUser.getId(), profileDto.getUserId());
        } else {
            log.warn("Beğenme işlemi sırasında bir sorun oluştu!");
        }

        // Profil listesindeki sırayı güncelle
        Integer currentProfileIndex = (Integer) session.getAttribute("currentProfileIndex");
        log.info(currentProfileIndex.toString());
        if (currentProfileIndex != null) {
            currentProfileIndex++;
            if (currentProfileIndex >= getAllUsers().size()) {
                currentProfileIndex = 0;
            }
            session.setAttribute("currentProfileIndex", currentProfileIndex);
        }
    }


}
