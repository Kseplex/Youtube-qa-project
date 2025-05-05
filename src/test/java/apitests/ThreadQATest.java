package apitests;


import api.threadqa.client.ThreadQAUserClient;
import api.threadqa.model.response.signup.Info;
import org.junit.jupiter.api.Test;
import uitests.pendrak.common.util.DataGenerator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ThreadQATest {

    private final ThreadQAUserClient threadQAUserClient = new ThreadQAUserClient();

    DataGenerator faker = new DataGenerator();

    @Test
    public void userRegistrationTest(){
        Info expectedInfo = new Info().message("User created").status("success");
        assertThat(threadQAUserClient.signUp(faker.generateUser()).info()).isEqualTo(expectedInfo);
    }
}
