package apitests;

import apitests.steps.ActivitiesSteps;
import api.fakerestapi.client.FakeRestApiActivityClient;
import api.fakerestapi.model.Activity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class FakeRestApiTest {

    FakeRestApiActivityClient fakeRestApiActivityClient = new FakeRestApiActivityClient();

    ActivitiesSteps activitiesSteps = new ActivitiesSteps();

    @Test
    @DisplayName("Проверка Activities")
    public void apiActivitiesTest(){
        List<Activity> activityList = fakeRestApiActivityClient.getActivitiesList();
        Activity activityFiltered = activitiesSteps.checkActivities(activityList);
        assertThat(activityFiltered).isNotNull();
        Activity activityFoundById = fakeRestApiActivityClient.getActivityById(activityFiltered.id());
        activitiesSteps.compareActivityToPrevious(activityFoundById, activityFiltered);
    }
}
