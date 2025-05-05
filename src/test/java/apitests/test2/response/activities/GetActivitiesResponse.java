package apitests.test2.response.activities;

import java.util.List;

import apitests.test2.request.activities.Activity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain=true, fluent=true)
public class GetActivitiesResponse{

	private Activity[] getActivitiesResponse;
}