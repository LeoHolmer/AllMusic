package com.leoholmer.AllMusic.model;

public class Song {
    private String id;
    private String name;
    private MusicArtist author;
    private Genre genre;

    public Song(Genre genre, MusicArtist author, String name, String id) {
        this.genre = genre;
        this.author = author;
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MusicArtist getAuthor() {
        return author;
    }

    public void setAuthor(MusicArtist author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
