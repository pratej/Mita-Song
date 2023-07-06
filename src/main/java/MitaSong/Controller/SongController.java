package MitaSong.Controller;

import MitaSong.Pojo.Song;
import MitaSong.Services.SongService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/songs")
@CrossOrigin(origins = "")
public class SongController {

    @Autowired
    private SongService songService;

    @ApiIgnore
    @RequestMapping()
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping(value = "/{songId}", produces = "application/json")
    public ResponseEntity<Song> getSongById(@PathVariable String songId) {
        Song song = songService.getSongById(songId);
        if (song != null) {
            return new ResponseEntity<>(song, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        Song createdSong = songService.createSong(song);
        return new ResponseEntity<>(createdSong, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{songId}", produces = "application/json")
    public ResponseEntity<Song> updateSong(
            @PathVariable String songId,
            @RequestBody Song updatedSong
    ) {
        Song song = songService.updateSong(songId, updatedSong);
        if (song != null) {
            return new ResponseEntity<>(song, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{songId}", produces = "application/json")
    public ResponseEntity<Song> deleteSongById(@PathVariable String songId) {
        boolean deleted = songService.deleteSong(songId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}