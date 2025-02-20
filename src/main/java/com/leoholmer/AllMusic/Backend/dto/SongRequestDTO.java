package com.leoholmer.AllMusic.Backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SongRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Genre is required")
    private String genre;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}