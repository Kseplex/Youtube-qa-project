package apitests.model.response.signup;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain=true, fluent=true)
public class Info{

	@JsonProperty("message")
	private String message;

	@JsonProperty("status")
	private String status;
}