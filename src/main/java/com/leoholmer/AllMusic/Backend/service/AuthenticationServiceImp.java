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
        // Buscar al usuario por su nombre de usuario
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser == null) {
            throw new Exception("User not found");
        }

        // Verificar la contraseña
        if (!passwordEncoder.verify(user.getPassword(), existingUser.getPassword())) {
            throw new Exception("Invalid password");
        }

        // Generar y devolver el token JWT
        return jwtTokenUtil.generateToken(existingUser.getUsername());
    }
}