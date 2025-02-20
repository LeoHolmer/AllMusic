package com.leoholmer.AllMusic.Backend.service;

import com.leoholmer.AllMusic.Backend.model.User;
import com.leoholmer.AllMusic.Backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) throws Exception {
        return userRepository.findByUsername(username);
    }
}