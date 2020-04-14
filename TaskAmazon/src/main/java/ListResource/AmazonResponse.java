package ListResource;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
