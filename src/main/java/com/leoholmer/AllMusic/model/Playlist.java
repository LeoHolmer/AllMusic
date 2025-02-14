package com.leoholmer.AllMusic.model;

import java.util.List;

public class Playlist {
    private long id;
    private String name;
    private User owner;
    private List<Song> songs;

    public Playlist(long id, String name, List<Song> songs) {
        this.songs = songs;
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
