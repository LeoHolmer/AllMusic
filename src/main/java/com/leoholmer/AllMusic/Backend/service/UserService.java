package com.leoholmer.AllMusic.Backend.service;


import com.leoholmer.AllMusic.Backend.model.User;

public interface UserService {
    User findByUsername(String username) throws Exception;
}