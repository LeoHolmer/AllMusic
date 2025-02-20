package com.leoholmer.AllMusic.Backend.service;

import com.leoholmer.AllMusic.Backend.exception.UnauthorizedException;
import com.leoholmer.AllMusic.Backend.model.User;
import com.leoholmer.AllMusic.Backend.repository.UserRepository;
import com.leoholmer.AllMusic.Backend.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationServiceImp implements AuthorizationService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User authorize(String token) {
        // Se espera que el token tenga el formato "Bearer <token>"
        if (token == null || !token.startsWith("Bearer ")) {
            throw new UnauthorizedException("Invalid token");
        }
        String jwt = token.substring(7);
        if (!jwtTokenUtil.verify(jwt)) {
            throw new UnauthorizedException("Invalid token");
        }
        String username = jwtTokenUtil.getSubject(jwt);
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.orElseThrow(() -> new UnauthorizedException("User not found"));
    }
}
