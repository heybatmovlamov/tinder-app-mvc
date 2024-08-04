package com.example.tinder.model.repository.messageRepo;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository {
    String sendMessage(String message , long userId);
    String getMessage(long userId);
}
