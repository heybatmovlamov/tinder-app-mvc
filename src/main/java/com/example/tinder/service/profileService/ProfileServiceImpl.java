package com.example.tinder.service.profileService;

import com.example.tinder.model.dto.ProfileDto;
import com.example.tinder.model.dto.UserDto;
import com.example.tinder.model.entity.ProfileEntity;
import com.example.tinder.model.repository.PeopleRepo.ProfileRepository;
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
        return profileRepository.users();
    }

    @Override
    public void likeOrDislike(boolean like, long userId, long likedUserId) {
        profileRepository.likeOrDislike(like, userId, likedUserId);
    }

    @Override
    public void likeGet(Model model, HttpSession session) {
        List<ProfileEntity> allUsers = getAllUsers();

        if (currentProfileIndex == allUsers.size()){
            currentProfileIndex=0;
        }
        ProfileEntity entity = allUsers.get(currentProfileIndex);

        ProfileDto profileDto = new ProfileDto(entity.getUsername(), entity.getPhotoUrl(), entity.getUserId());
        session.setAttribute("profileDto", profileDto);//usersler

        UserDto loggedInUser = (UserDto) session.getAttribute("loggedInUser");//login olmush user


        if (profileDto.getUserId() == loggedInUser.getId()) {

            currentProfileIndex++;
            if (currentProfileIndex == allUsers.size()){
                currentProfileIndex=0;
            }
            ProfileEntity entity2 = allUsers.get(currentProfileIndex);
            ProfileDto profileDto2 = new ProfileDto(entity2.getUsername(), entity2.getPhotoUrl(), entity2.getUserId());

            model.addAttribute("username", profileDto2.getUsername());
            model.addAttribute("photoUrl", profileDto2.getPhotoUrl());
        } else {
            model.addAttribute("username", profileDto.getUsername());
            model.addAttribute("photoUrl", profileDto.getPhotoUrl());
            currentProfileIndex++;
        }

    }


    @Override
    public void likePost(HttpSession session, boolean like) {
        if (like) {
            UserDto loggedInUser = (UserDto) session.getAttribute("loggedInUser");
            long loggedInUserId = loggedInUser.getId();

            ProfileDto profileDto = (ProfileDto) session.getAttribute("profileDto");
            long userId = profileDto.getUserId();
            if (loggedInUserId == userId){
                return;
            }
            log.info("loggedInUser "+ loggedInUserId);
            log.info("profileDto " + userId);

            likeOrDislike(true, loggedInUserId, userId);
        } else {
            log.warn("some problem in like proses !");
        }
    }
}

