package com.example.tinder.model.repository.PeopleRepo;

import com.example.tinder.model.entity.ProfileEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository {
    List<ProfileEntity> users ();


    void likeOrDislike(boolean like, long userId, long likedUserId);

}
