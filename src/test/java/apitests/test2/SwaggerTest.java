package apitests.test2;

import apitests.test2.client.ThreadQAActivityClient;
import apitests.test2.request.activities.Activity;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SwaggerTest {

    ThreadQAActivityClient threadQAActivityClient = new ThreadQAActivityClient();

    ActivitiesSteps activitiesSteps = new ActivitiesSteps();

    @Test
    @DisplayName("Проверка Activities")
    public void apiActivitiesTest(){
        List<Activity> activityList = threadQAActivityClient.getActivitiesList();
        Activity activityFiltered = activitiesSteps.checkActivities(activityList);
        assertThat(activityFiltered).isNotNull();
        Activity activityFoundById = threadQAActivityClient.getActivityById(activityFiltered.id());
        activitiesSteps.compareActivityToPrevious(activityFoundById, activityFiltered);
    }
}
