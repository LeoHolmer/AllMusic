import com.leoholmer.AllMusic.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
public class SongResource {

    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<List<SongDTO>> getSongs(
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) Genre genre) {
        List<Song> songs = songService.getSongs(artist, genre);
        List<SongDTO> songDTOs = songs.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(songDTOs);
    }

    private SongDTO convertToDTO(Song song) {
        SongDTO dto = new SongDTO();
        dto.setId(song.getId());
        dto.setName(song.getTitle());
        dto.setGenre(song.getGenre());
        dto.setArtist(song.getArtist().getUsername());
        return dto;
    }
}