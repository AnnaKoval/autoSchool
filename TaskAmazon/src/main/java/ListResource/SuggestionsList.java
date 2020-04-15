package ListResource;

import com.fasterxml.jackson.annotation.*;

@JsonInclude()
@JsonPropertyOrder({
        "value"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class SuggestionsList {

    @JsonProperty("value")
    private String value;

    @JsonProperty("value")
    public String getValue() {
        return value;
    }
}
