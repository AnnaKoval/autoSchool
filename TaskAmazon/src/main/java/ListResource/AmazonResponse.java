package ListResource;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonInclude()
@JsonPropertyOrder({
        "suggestions"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmazonResponse {
    @JsonProperty("suggestions")
    private List<SuggestionsList> suggestions;

    @JsonProperty("suggestions")
    public List<SuggestionsList> getSuggestions() {
        return suggestions;
    }
}
