package MitaSong.Repository;

import MitaSong.Pojo.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepo extends MongoRepository<Song,String> {
    Song getSongById(String songId);

    boolean deleteSong(String songId);

    Song updateSong(Song song);

    Song saveSong(Song song);

    List<Song> getAllSongs();
}
