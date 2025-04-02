package apitests.model.request.signup;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain=true, fluent=true)
public class User {

    @JsonProperty("login")
    private String login;

    @JsonProperty("pass")
    private String pass;

}
