package apitests.test2;

import apitests.test2.client.ThreadQAActivityClient;
import apitests.test2.request.activities.Activity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwaggerTest {

    ThreadQAActivityClient threadQAActivityClient = new ThreadQAActivityClient();

    @Test
    @DisplayName("Проверка Activities")
    public void apiActivitiesTest(){
        List<Activity> activityList = threadQAActivityClient.getActivitieList();
        activityList.forEach(activity -> assertThat(activity, instanceOf(Activity.class)));
        assertTrue(threadQAActivityClient.checkActivitie(activityList).);
    }
}
