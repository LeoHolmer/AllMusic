package com.leoholmer.AllMusic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "music_enthusiast_users")
public class MusicEnthusiastUser extends User{

    public MusicEnthusiastUser(String username, String password) {
        super(username, password);
    }

    public MusicEnthusiastUser() {
        super();
    }

    public boolean canCreateSongs (){
        return false;
    }


}
