package com.leoholmer.AllMusic.Backend.service;

import com.leoholmer.AllMusic.Backend.model.User;

public interface AuthenticationService {
    String authenticate(User user) throws Exception;
}