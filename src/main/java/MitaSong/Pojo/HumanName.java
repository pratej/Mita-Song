package MitaSong.Pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HumanName {

    private String use;

    private String fullName;

    private String family;

    private String given;

    private String prefix;

    private String suffix;

    private long startTime;
    private long endTime;
}
