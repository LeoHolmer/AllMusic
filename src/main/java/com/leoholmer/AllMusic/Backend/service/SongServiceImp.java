package com.leoholmer.AllMusic.Backend.service;

import com.leoholmer.AllMusic.Backend.model.Genre;
import com.leoholmer.AllMusic.Backend.model.MusicArtistUser;
import com.leoholmer.AllMusic.Backend.model.Playlist;
import com.leoholmer.AllMusic.Backend.model.Song;
import com.leoholmer.AllMusic.Backend.model.User;
import com.leoholmer.AllMusic.Backend.repository.SongRepository;
import com.leoholmer.AllMusic.Backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImp implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Song> getSongs(String artist, Genre genre) {
        if (artist != null && genre != null) {
            return songRepository.findByArtistUsernameAndGenre(artist, genre);
        } else if (artist != null) {
            return songRepository.findByArtistUsername(artist);
        } else if (genre != null) {
            return songRepository.findByGenre(genre);
        }
        return songRepository.findAll();
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void createSong(Song song, User user) throws Exception {
        if (!(user instanceof MusicArtistUser)) {
            throw new Exception("Only music artists can create songs.");
        }
        song.setArtist((MusicArtistUser) user);
        songRepository.save(song);
    }

    @Override
    public void updateSong(Long id, Song updatedSong, User user) throws Exception {
        Song song = songRepository.findById(id).orElseThrow(() -> new Exception("Song not found"));
        if (!song.getArtist().equals(user)) {
            throw new Exception("You can only update your own songs.");
        }
        song.setTitle(updatedSong.getTitle());
        song.setGenre(updatedSong.getGenre());
        songRepository.save(song);
    }

    @Override
    public void deleteSong(Long id, User user) throws Exception {
        Song song = songRepository.findById(id).orElseThrow(() -> new Exception("Song not found"));
        if (!song.getArtist().equals(user)) {
            throw new Exception("You can only delete your own songs.");
        }
        songRepository.delete(song);
    }

    @Override
    public List<Playlist> getSongsByUser(User user) {
        return ((MusicArtistUser) user).getPlaylists();
    }
}