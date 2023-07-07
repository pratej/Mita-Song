package MitaSong.Repository;

import MitaSong.Pojo.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepo extends MongoRepository<Song,String> {
}
