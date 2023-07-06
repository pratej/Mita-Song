package MitaSong.Pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModelBase {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("createdDate")
    private long createdDate;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("modifiedDate")
    private long modifiedDate;

    @JsonProperty("modifiedBy")
    private String modifiedBy;

    public ModelBase(){
        super();
        this.createdDate = System.currentTimeMillis();
        this.modifiedDate = System.currentTimeMillis();
    }


    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
