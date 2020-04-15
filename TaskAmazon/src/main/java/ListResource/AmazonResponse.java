package ListResource;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonInclude()
@JsonPropertyOrder({
        "suggestions"
})

public class AmazonResponse {
    @JsonProperty("suggestions")
    private List<SuggestionsList> suggestions;

    @JsonProperty("data")
    public List<SuggestionsList> getSuggestions() {
        return suggestions;
    }

    @JsonProperty("data")
    public void setSuggestions(List<SuggestionsList> suggestions) {
        this.suggestions = suggestions;
    }
}
