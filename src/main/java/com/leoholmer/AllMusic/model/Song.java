package com.leoholmer.AllMusic.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private MusicArtistUser artist;

    public Song(Genre genre, MusicArtistUser artist, String title) {
        this.genre = genre;
        this.artist = artist;
        this.title = title;
    }

    public Song() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public MusicArtistUser getArtist() {
        return artist;
    }

    public void setArtist(MusicArtistUser artist) {
        this.artist = artist;
    }
}
