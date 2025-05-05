package apitests.test2;

import apitests.test2.request.activities.Activity;
import io.qameta.allure.Step;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActivitiesSteps {
    @Step("Находим в списке полученных активностей любую активность с номером 20+ и completed=false")
    public Activity findActivityInList(List<Activity> activityList) {
        for (Activity activity : activityList) {
            if (activity.id() > 20 && !activity.completed()) {
                return activity;
            }
        }
        return null;
    }

    @Step("Проверяем, что получен список активностей")
    public void checkActivitiesList(List<Activity> activitiesList)  {
        activitiesList.forEach(activity -> assertThat(activity, instanceOf(Activity.class)));
    }

    @Step("Проверяем, что такая запись присутствует")
    public void checkActivityInList(Activity activity, List<Activity> activitiesList) {
        assertTrue(activitiesList.contains(activity));
    }

    @Step("Проверяем, что запись из шага 2 идентична записи из шага 3")
    public void compareActivityToPrevious(Activity activityCurrent, Activity activityPrevious) {
        assertEquals(activityCurrent, activityPrevious);
    }
}
