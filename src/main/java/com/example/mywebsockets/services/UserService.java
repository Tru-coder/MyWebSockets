package com.example.mywebsockets.services;

import com.example.mywebsockets.domain.user.Status;
import com.example.mywebsockets.domain.user.User;
import com.example.mywebsockets.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getOnlineUsers(){
        return userRepository.findAllByStatusAndIsDeletedIsFalse(Status.ONLINE);
    }

}
