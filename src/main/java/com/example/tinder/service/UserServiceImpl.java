package com.example.tinder.service;

import com.example.tinder.model.dto.UserDto;
import com.example.tinder.model.entity.User;
import com.example.tinder.model.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User login(String email, String password) {
        User login = userRepository.login(email, password);
        if (login !=null) {
            return login;
        }else {
            throw new UserNotFoundException();
        }
    }
    public ModelAndView login(@Valid UserDto userDTO) {
        ModelAndView model = new ModelAndView();
        User login = userRepository.login(userDTO.getEmail(), userDTO.getPassword());
        if(login!=null){
            model.setViewName("people-list");
            return model;
        }
        model.setViewName("login");
        return model;
    }
}
