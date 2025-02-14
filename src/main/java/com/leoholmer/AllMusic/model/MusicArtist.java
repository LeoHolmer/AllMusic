package com.leoholmer.AllMusic.model;

public class MusicArtist extends User{

    public MusicArtist(long id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public boolean canCreateSongs() {
        return true;
    }


}
