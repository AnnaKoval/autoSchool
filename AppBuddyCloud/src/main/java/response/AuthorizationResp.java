package response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude()
@JsonPropertyOrder({
        "token"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizationResp {
    @JsonProperty("token")
    private String token;

    @JsonProperty("token")
    public String getToken() {
        return token;
    }
}