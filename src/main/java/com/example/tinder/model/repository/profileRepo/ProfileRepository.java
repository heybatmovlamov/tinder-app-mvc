package com.example.tinder.model.repository.profileRepo;

import com.example.tinder.model.entity.ProfileEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository {
    List<ProfileEntity> getAllUsers ();


    void likeOrDislike(boolean like, long userId, long likedUserId);

}
