package apitests.test2;

import apitests.test2.client.ThreadQAActivityClient;
import apitests.test2.client.ThreadQAActivityIdClient;
import apitests.test2.request.activities.Activity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SwaggerTest {

    ThreadQAActivityClient threadQAActivityClient = new ThreadQAActivityClient();
    ThreadQAActivityIdClient threadQAActivityIdClient = new ThreadQAActivityIdClient();
    ActivitiesSteps activitiesSteps = new ActivitiesSteps();

    @Test
    @DisplayName("Проверка Activities")
    public void apiActivitiesTest(){
        List<Activity> activitiesList = threadQAActivityClient.getActivitiesList();
        activitiesSteps.checkActivitiesList(activitiesList);

        Activity activity = activitiesSteps.findActivityInList(activitiesList);
        activitiesSteps.checkActivityInList(activity, activitiesList);

        activitiesSteps.compareActivityToPrevious(threadQAActivityIdClient.getActivityById(activity.id()), activity);
    }
}
