package com.leoholmer.AllMusic.resource;

import com.leoholmer.AllMusic.dto.CreateUserRequestDTO;
import com.leoholmer.AllMusic.model.MusicArtistUser;
import com.leoholmer.AllMusic.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class MusicArtistUserResource {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDTO dto) {
        try {
            MusicArtistUser user = modelMapper.map(dto, MusicArtistUser.class);
            userService.create(user);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
}