package com.leoholmer.AllMusic.Backend.repository;

import com.leoholmer.AllMusic.Backend.model.Playlist;
import com.leoholmer.AllMusic.Backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    // Buscar playlists por usuario
    List<Playlist> findByUser(User user);

    // Buscar una playlist por ID
    Playlist findByIdAndUser(Long id, User user);



}