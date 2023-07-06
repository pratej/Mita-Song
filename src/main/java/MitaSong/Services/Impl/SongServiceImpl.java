package MitaSong.Services.Impl;

import MitaSong.Pojo.Song;
import MitaSong.Repository.SongRepo;
import MitaSong.Services.SongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class SongServiceImpl implements SongService {

    private final SongRepo songRepository;

    @Override
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    @Override
    public Song getSongById(String songId) {
        return songRepository.getSongById(songId);
    }

    @Override
    public Song createSong(Song song) {
        String songId = UUID.randomUUID().toString();
        song.setId(songId);
        return songRepository.saveSong(song);
    }

    @Override
    public Song updateSong(String songId, Song updatedSong) {
        Song song = songRepository.getSongById(songId);
        if (song != null) {
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
            return songRepository.updateSong(song);
        }
        return null;
    }

    @Override
    public boolean deleteSong(String songId) {
        Song song = songRepository.getSongById(songId);
        if (song != null) {
            return songRepository.deleteSong(songId);
        }
        return false;
    }
}
