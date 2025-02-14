package com.leoholmer.AllMusic.model;

public class MusicEnthusiast extends User{
    private String artisticName ;

    public MusicEnthusiast(long id, String username, String password, String artisticName) {
        super(id, username, password);
        this.artisticName = artisticName;
    }

    public boolean canCreateSongs (){
        return false;
    }

    public String getArtisticName() {
        return artisticName;
    }

    public void setArtisticName(String artisticName) {
        this.artisticName = artisticName;
    }
}
