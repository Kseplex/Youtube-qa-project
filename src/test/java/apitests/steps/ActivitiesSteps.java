package apitests.steps;

import api.fakerestapi.model.Activity;
import io.qameta.allure.Step;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ActivitiesSteps {


    @Step("Найти в списке полученных активностей любую активность с номером 20+ и completed=false, проверить," +
            " что такая запись присутствует")
    public Activity checkActivities(List<Activity> activityList) {
        if (activityList != null) {
            return activityList.stream().filter(x -> !x.completed() && x.id() > 20).findFirst().orElse(null);
        }
        return null;
    }

    @Step("Проверяем, что запись из шага 2 идентична записи из шага 3")
    public void compareActivityToPrevious(Activity activityCurrent, Activity activityPrevious) {
        assertAll(
                () -> assertThat(activityCurrent.title()).isEqualTo(activityPrevious.title()),
                () -> assertThat(activityCurrent.id()).isEqualTo(activityPrevious.id()),
                () -> assertThat(activityCurrent.completed()).isEqualTo(activityPrevious.completed()),
                () -> assertThat(ZonedDateTime.parse(activityCurrent.dueDate()))
                        .isBetween(ZonedDateTime.parse(activityPrevious.dueDate()).minusSeconds(5),
                                ZonedDateTime.parse(activityPrevious.dueDate()).plusSeconds(5))
        );
    }
}
