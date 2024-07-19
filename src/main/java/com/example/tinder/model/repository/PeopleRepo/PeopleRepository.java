package com.example.tinder.model.repository.PeopleRepo;

import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository {
    String users (boolean likeOrDislike);
}
