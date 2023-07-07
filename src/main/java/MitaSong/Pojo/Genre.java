package MitaSong.Pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection="Genre")
public class Genre extends Song{

    private String genreId;
    private String name;

}
