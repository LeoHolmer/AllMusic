package com.leoholmer.AllMusic.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table (name = "music_artist_users")
public class MusicArtistUser extends User{
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs;

    public MusicArtistUser(String username, String password) {
        super(username, password);
    }

    public MusicArtistUser() {

    }

    @Override
    public boolean canCreateSongs() {
        return true;
    }

    public void addSong(Song song){
        songs.add(song);
        song.setArtist(this);
    }

}
