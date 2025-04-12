package apitests.test1.model.response.signup;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain=true, fluent=true)
public class RegisterData{

	@JsonProperty("pass")
	private String pass;

	@JsonProperty("games")
	private List<Object> games;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("login")
	private String login;

}