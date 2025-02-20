package com.leoholmer.AllMusic.Backend.dto;

import lombok.Data;

@Data
public class CreateUserRequestDTO {
    private String username;
    private String password;
}
