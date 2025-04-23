package apitests.test1;


import apitests.test1.client.ThreadQAUserClient;
import apitests.test1.model.response.signup.Info;
import org.junit.jupiter.api.Test;
import uitests.pendrak.common.util.DataGenerator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SwaggerTest {

    private final ThreadQAUserClient threadQAUserClient = new ThreadQAUserClient();

    DataGenerator faker = new DataGenerator();

    @Test
    public void userRegistrationTest() {
        Info expectedInfo = new Info().message("User created").status("success");
        assertThat(threadQAUserClient.signUp(faker.generateUser()).info()).isEqualTo(expectedInfo);
    }
}
