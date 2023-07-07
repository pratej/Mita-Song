package MitaSong.Pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document
public class Song extends ModelBase {

    private String songId;
    private String title;
    private Artist artist;
    private String featuredArtists;
    private String description;
    private List<String> audio;
    private String album;
    private List<String> image;
    private String language;
    private Date releaseDate;
    private Stats stats;
    private Genre genre;

}
