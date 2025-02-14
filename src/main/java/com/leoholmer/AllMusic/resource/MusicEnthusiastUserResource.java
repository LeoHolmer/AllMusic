package com.leoholmer.AllMusic.resource;

import com.leoholmer.AllMusic.dto.CreateUserRequestDTO;
import com.leoholmer.AllMusic.model.MusicEnthusiastUser;
import com.leoholmer.AllMusic.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enthusiast")
public class MusicEnthusiastUserResource {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDTO dto) {
        try {
            MusicEnthusiastUser user = modelMapper.map(dto, MusicEnthusiastUser.class);
            userService.create(user);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
}