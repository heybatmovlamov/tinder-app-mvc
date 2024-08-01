package com.example.tinder.service.messageService;

import com.example.tinder.model.repository.messageRepo.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService{

    private final MessageRepository repository;
    @Override
    public String sendMessage(String message , long userId) {
        return repository.sendMessage(message,userId);
    }

//    @Override
//    public boolean acceptMessage(long id) {
//        return repository.acceptMessage(id);
//    }
    @Override
    public String getMessage(long userId){
        return repository.getMessage(userId);
    }
}
