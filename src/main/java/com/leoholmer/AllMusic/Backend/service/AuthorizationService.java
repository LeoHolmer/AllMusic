package com.leoholmer.AllMusic.Backend.service;


import com.leoholmer.AllMusic.Backend.model.User;

public interface AuthorizationService {
    User authorize(String token) throws Exception;
}