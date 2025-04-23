package apitests.test2;

import apitests.test2.client.ThreadQAActivities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SwaggerTest {

    private final ThreadQAActivities threadQAActivities = new ThreadQAActivities();

    @Test
    @DisplayName("Проверка Activities")
    public void ActivitiesTest() {
        threadQAActivities.getActivities();
    }
}
