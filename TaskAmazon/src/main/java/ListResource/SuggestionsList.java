package ListResource;

import com.fasterxml.jackson.annotation.*;

@JsonInclude()
@JsonPropertyOrder({
        "value"
})

public class SuggestionsList {

    @JsonProperty("value")
    private String value;

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

}
