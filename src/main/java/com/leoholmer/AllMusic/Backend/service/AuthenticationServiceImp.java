package com.leoholmer.AllMusic.Backend.service;

import com.leoholmer.AllMusic.Backend.model.User;
import com.leoholmer.AllMusic.Backend.util.JwtTokenUtil;
import com.leoholmer.AllMusic.Backend.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String authenticate(User user) throws Exception {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser == null || !passwordEncoder.verify(user.getPassword(), existingUser.getPassword())) {
            throw new Exception("Invalid credentials");
        }
        return jwtTokenUtil.generateToken(existingUser.getUsername());
    }
}