package MitaSong.Services;

import MitaSong.Pojo.Song;

import java.util.List;

public interface SongService {
    List<Song> getAllSongs();

    Song getSongById(String songId);

    Song createSong(Song song);

    Song updateSong(String songId, Song updatedSong);

    boolean deleteSong(String songId);
}
