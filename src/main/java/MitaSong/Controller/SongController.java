package MitaSong.Controller;

import MitaSong.Pojo.Artist;
import MitaSong.Pojo.Genre;
import MitaSong.Pojo.Song;
import MitaSong.Pojo.Stats;
import MitaSong.Services.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
@CrossOrigin(origins = "")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping(value = "/{songId}", produces = "application/json")
    public ResponseEntity<Song> getSongById(@PathVariable String songId) {
        Optional<Song> songOptional = songService.getSongById(songId);
        if (songOptional.isPresent()) {
            return new ResponseEntity<>(songOptional.get(), HttpStatus.OK);
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
    public ResponseEntity<Void> deleteSongById(@PathVariable String songId) {
        boolean deleted = songService.deleteSong(songId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value="/genre",produces = "application/json")
    public ResponseEntity<Genre> addGenre(@RequestBody Genre song) {
        Genre createdSong = songService.createGenre(song);
            return new ResponseEntity<>(createdSong, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{songId}/artist", produces = "application/json")
    public ResponseEntity<Artist> getArtistBySongId(@PathVariable String songId) {
        Optional<Artist> artistOptional = songService.getArtistBySongId(songId);
        if (artistOptional.isPresent()) {
            return new ResponseEntity<>(artistOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{songId}/artist", produces = "application/json")
    public ResponseEntity<Artist> updateArtistBySongId(
            @PathVariable String songId,
            @RequestBody Artist updatedArtist
    ) {
        Artist artist = songService.updateArtistBySongId(songId, updatedArtist);
        if (artist != null) {
            return new ResponseEntity<>(artist, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{songId}/genre", produces = "application/json")
    public ResponseEntity<Genre> getGenreBySongId(@PathVariable String songId) {
        Optional<Genre> genreOptional = songService.getGenreBySongId(songId);
        if (genreOptional.isPresent()) {
            return new ResponseEntity<>(genreOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{songId}/genre", produces = "application/json")
    public ResponseEntity<Genre> updateGenreBySongId(
            @PathVariable String songId,
            @RequestBody Genre updatedGenre
    ) {
        Genre genre = songService.updateGenreBySongId(songId, updatedGenre);
        if (genre != null) {
            return new ResponseEntity<>(genre, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{songId}/stats", produces = "application/json")
    public ResponseEntity<Stats> getStatsBySongId(@PathVariable String songId) {
        Optional<Stats> statsOptional = songService.getStatsBySongId(songId);
        if (statsOptional.isPresent()) {
            return new ResponseEntity<>(statsOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{songId}/stats", produces = "application/json")
    public ResponseEntity<Stats> updateStatsBySongId(
            @PathVariable String songId,
            @RequestBody Stats updatedStats
    ) {
        Stats stats = songService.updateStatsBySongId(songId, updatedStats);
        if (stats != null) {
            return new ResponseEntity<>(stats, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{songId}/artist", produces = "application/json")
    public ResponseEntity<Void> deleteArtistBySongId(@PathVariable String songId) {
        boolean deleted = songService.deleteArtistBySongId(songId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{songId}/genre", produces = "application/json")
    public ResponseEntity<Void> deleteGenreBySongId(@PathVariable String songId) {
        boolean deleted = songService.deleteGenreBySongId(songId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{songId}/stats", produces = "application/json")
    public ResponseEntity<Void> deleteStatsBySongId(@PathVariable String songId) {
        boolean deleted = songService.deleteStatsBySongId(songId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
