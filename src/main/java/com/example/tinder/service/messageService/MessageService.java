package com.example.tinder.service.messageService;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    String sendMessage(String message,long userId);

    //    @Override
    //    public boolean acceptMessage(long id) {
    //        return repository.acceptMessage(id);
    //    }
    String getMessage(long userId);
//    boolean  acceptMessage(long id);
}
