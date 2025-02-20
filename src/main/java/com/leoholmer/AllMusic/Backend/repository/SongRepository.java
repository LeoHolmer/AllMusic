package com.leoholmer.AllMusic.Backend.repository;

import com.leoholmer.AllMusic.Backend.model.Genre;
import com.leoholmer.AllMusic.Backend.model.MusicArtistUser;
import com.leoholmer.AllMusic.Backend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    // Buscar canciones por nombre del artista
    List<Song> findByArtistUsername(String username);

    // Buscar canciones por género
    List<Song> findByGenre(Genre genre);

    // Buscar canciones por nombre del artista y género
    List<Song> findByArtistUsernameAndGenre(String username, Genre genre);

    // Buscar una canción por ID y artista
    Song findByIdAndArtist(Long id, MusicArtistUser artist);
}