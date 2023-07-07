package MitaSong.Services;

import MitaSong.Pojo.Artist;
import MitaSong.Pojo.Genre;
import MitaSong.Pojo.Song;
import MitaSong.Pojo.Stats;
import MitaSong.Repository.SongRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SongService {

    private final SongRepo songRepository;

    @Autowired
    public SongService(SongRepo songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSongById(String songId) {
        return songRepository.findById(songId);
    }

    public Song createSong(Song song) {
        String songId = UUID.randomUUID().toString();
        song.setId(songId);
        song.setSongId(songId);
        return songRepository.save(song);
    }
    public Genre createGenre(Genre song) {
        String songId = UUID.randomUUID().toString();
        song.setGenreId(songId);
        return songRepository.save(song);
    }

    public Song updateSong(String songId, Song updatedSong) {
        Optional<Song> songOptional = songRepository.findById(songId);
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            song.setTitle(updatedSong.getTitle());
            song.setArtist(updatedSong.getArtist());
            song.setFeaturedArtists(updatedSong.getFeaturedArtists());
            song.setDescription(updatedSong.getDescription());
            song.setAudio(updatedSong.getAudio());
            song.setAlbum(updatedSong.getAlbum());
            song.setImage(updatedSong.getImage());
            song.setLanguage(updatedSong.getLanguage());
            song.setReleaseDate(updatedSong.getReleaseDate());
            song.setStats(updatedSong.getStats());
            song.setGenre(updatedSong.getGenre());
            return songRepository.save(song);
        }
        return null;
    }

    public boolean deleteSong(String songId) {
        if (songRepository.existsById(songId)) {
            songRepository.deleteById(songId);
            return true;
        }
        return false;
    }

    public Optional<Artist> getArtistBySongId(String songId) {
        Optional<Song> songOptional = songRepository.findById(songId);
        return songOptional.map(Song::getArtist);
    }

    public Artist updateArtistBySongId(String songId, Artist updatedArtist) {
        Optional<Song> songOptional = songRepository.findById(songId);
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            song.setArtist(updatedArtist);
            songRepository.save(song);
            return updatedArtist;
        }
        return null;
    }

    public Optional<Genre> getGenreBySongId(String songId) {
        Optional<Song> songOptional = songRepository.findById(songId);
        return songOptional.map(Song::getGenre);
    }

    public Genre updateGenreBySongId(String songId, Genre updatedGenre) {
        Optional<Song> songOptional = songRepository.findById(songId);
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            song.setGenre(updatedGenre);
            songRepository.save(song);
            return updatedGenre;
        }
        return null;
    }

    public Optional<Stats> getStatsBySongId(String songId) {
        Optional<Song> songOptional = songRepository.findById(songId);
        return songOptional.map(Song::getStats);
    }

    public Stats updateStatsBySongId(String songId, Stats updatedStats) {
        Optional<Song> songOptional = songRepository.findById(songId);
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            song.setStats(updatedStats);
            songRepository.save(song);
            return updatedStats;
        }
        return null;
    }

    public boolean deleteArtistBySongId(String songId) {
        Optional<Song> songOptional = songRepository.findById(songId);
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            song.setArtist(null);
            songRepository.save(song);
            return true;
        }
        return false;
    }

    public boolean deleteGenreBySongId(String songId) {
        Optional<Song> songOptional = songRepository.findById(songId);
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            song.setGenre(null);
            songRepository.save(song);
            return true;
        }
        return false;
    }

    public boolean deleteStatsBySongId(String songId) {
        Optional<Song> songOptional = songRepository.findById(songId);
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            song.setStats(null);
            songRepository.save(song);
            return true;
        }
        return false;
    }
}
