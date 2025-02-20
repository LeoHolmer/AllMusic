package com.leoholmer.AllMusic.Backend.service;

import com.leoholmer.AllMusic.Backend.model.User;
import com.leoholmer.AllMusic.Backend.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImp implements AuthorizationService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public User authorize(String token) throws Exception {
        if (!jwtTokenUtil.verify(token)) {
            throw new Exception("Invalid token");
        }
        String username = jwtTokenUtil.getSubject(token);
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new Exception("User not found");
        }
        return user;
    }
}