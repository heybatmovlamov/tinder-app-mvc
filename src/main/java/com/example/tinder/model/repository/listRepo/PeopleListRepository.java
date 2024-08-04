package com.example.tinder.model.repository.listRepo;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PeopleListRepository {
    List<Integer> chooseLikedUser(long id);

}
