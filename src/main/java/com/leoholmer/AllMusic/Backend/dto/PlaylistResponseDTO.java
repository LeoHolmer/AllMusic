package com.leoholmer.AllMusic.Backend.dto;

public class PlaylistResponseDTO {

    private Long id; // Identificador único de la playlist
    private String name; // Nombre de la playlist
    private String ownerName; // Nombre del usuario propietario de la playlist
    private int songCount; // Cantidad de canciones en la playlist

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }
}