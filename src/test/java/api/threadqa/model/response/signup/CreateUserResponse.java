package api.threadqa.model.response.signup;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain=true, fluent=true)
public class CreateUserResponse{

	@JsonProperty("register_data")
	private RegisterData registerData;

	@JsonProperty("info")
	private Info info;

}