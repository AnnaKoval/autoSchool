package response;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonInclude()
@JsonPropertyOrder({
        "rows"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppResponse {
    @JsonProperty("rows")
    private List<RowsList> rows;

    @JsonProperty("rows")
    public List<RowsList> getRows() {
        return rows;
    }
}
