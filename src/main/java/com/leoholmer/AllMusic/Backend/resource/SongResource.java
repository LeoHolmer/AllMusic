    package com.leoholmer.AllMusic.Backend.resource;

    import com.leoholmer.AllMusic.Backend.dto.SongRequestDTO;
    import com.leoholmer.AllMusic.Backend.dto.SongResponseDTO;
    import com.leoholmer.AllMusic.Backend.model.Genre;
    import com.leoholmer.AllMusic.Backend.model.Playlist;
    import com.leoholmer.AllMusic.Backend.model.Song;
    import com.leoholmer.AllMusic.Backend.model.User;
    import com.leoholmer.AllMusic.Backend.service.AuthorizationService;
    import com.leoholmer.AllMusic.Backend.service.SongService;
    import org.modelmapper.ModelMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.stream.Collectors;

    @RestController
    @RequestMapping("/songs")
    public class SongResource {

        @Autowired
        private AuthorizationService authorizationService;

        @Autowired
        private SongService songService;

        @Autowired
        private ModelMapper modelMapper;

        // GET /songs?artist=:artist_name&genre=:genre
        @GetMapping
        public ResponseEntity<?> getSongs(
                @RequestParam(required = false) String artist,
                @RequestParam(required = false) Genre genre,
                @RequestHeader("Authorization") String token) {
            try {
                User user = authorizationService.authorize(token);
                List<Song> songs = songService.getSongs(artist, genre);
                List<SongResponseDTO> response = songs.stream()
                        .map(song -> modelMapper.map(song, SongResponseDTO.class))
                        .collect(Collectors.toList());
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                return ResponseEntity.status(403).body(e.getMessage());
            }
        }

        // GET /songs/:id
        @GetMapping("/{id}")
        public ResponseEntity<?> getSong(@PathVariable Long id, @RequestHeader("Authorization") String token) {
            try {
                authorizationService.authorize(token);
                Song song = songService.getSongById(id);
                if (song == null) {
                    return ResponseEntity.status(404).body("Song not found");
                }
                return ResponseEntity.ok(modelMapper.map(song, SongResponseDTO.class));
            } catch (Exception e) {
                return ResponseEntity.status(403).body(e.getMessage());
            }
        }

        // POST /songs
        @PostMapping
        public ResponseEntity<?> createSong(@RequestBody SongRequestDTO dto, @RequestHeader("Authorization") String token) {
            try {
                User user = authorizationService.authorize(token);
                if (!user.canCreateSongs()) {
                    return ResponseEntity.status(403).body("Only music artists can create songs");
                }
                Song song = new Song();
                song.setTitle(dto.getName());
                try {
                    Genre genre = Genre.valueOf(dto.getGenre());
                    song.setGenre(genre);
                } catch (IllegalArgumentException e) {
                    return ResponseEntity.status(400).body("Invalid genre");
                }
                song.setArtist(user);
                songService.createSong(song, user); // Agregar el parámetro 'user'
                return ResponseEntity.status(201).build();
            } catch (Exception e) {
                return ResponseEntity.status(400).body(e.getMessage());
            }
        }

        // PUT /songs/:id
        @PutMapping("/{id}")
        public ResponseEntity<?> updateSong(@PathVariable Long id, @RequestBody SongRequestDTO dto, @RequestHeader("Authorization") String token) {
            try {
                User user = authorizationService.authorize(token);
                Song song = songService.getSongById(id);
                if (song == null || !song.getArtist().equals(user)) {
                    return ResponseEntity.status(403).body("You are not authorized to update this song");
                }
                song.setTitle(dto.getName());
                song.setGenre(Genre.valueOf(dto.getGenre()));
                songService.updateSong(id, song, user);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                return ResponseEntity.status(400).body(e.getMessage());
            }
        }

        // DELETE /songs/:id
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteSong(@PathVariable Long id, @RequestHeader("Authorization") String token) {
            try {
                User user = authorizationService.authorize(token);
                Song song = songService.getSongById(id);
                if (song == null || !song.getArtist().equals(user)) {
                    return ResponseEntity.status(403).body("You are not authorized to delete this song");
                }
                songService.deleteSong(id, user);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                return ResponseEntity.status(400).body(e.getMessage());
            }
        }

        // GET /me/songs
        @GetMapping("/me/songs")
        public ResponseEntity<?> getCurrentUserSongs(@RequestHeader("Authorization") String token) {
            try {
                User user = authorizationService.authorize(token);
                List<Playlist> Playlist = songService.getSongsByUser(user);
                List<SongResponseDTO> response = Playlist.stream()
                        .map(song -> modelMapper.map(song, SongResponseDTO.class))
                        .collect(Collectors.toList());
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                return ResponseEntity.status(403).body(e.getMessage());
            }
        }
    }