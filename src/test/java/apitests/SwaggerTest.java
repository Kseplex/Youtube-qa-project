package apitests;


import apitests.client.ThreadQAUserClient;
import apitests.model.response.signup.Info;
import org.junit.jupiter.api.Test;
import uitests.common.util.DataGenerator;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwaggerTest {

    private final ThreadQAUserClient threadQAUserClient = new ThreadQAUserClient();

    DataGenerator faker = new DataGenerator();

    @Test
    public void userRegistrationTest(){
        Info expectedInfo = new Info().message("User created").status("success");
        assertThat(threadQAUserClient.signUp(faker.generateUser()).info()).isEqualTo(expectedInfo);
    }
}
