package apitests.test2.client;

import apitests.test2.request.activities.Activity;
import io.qameta.allure.Step;
import java.util.List;

import static apitests.test2.Specifications.getThreadQaSpec;
import static io.restassured.RestAssured.given;

public class ThreadQAActivityClient {

    @Step("Вызвать метод Get api/v1/activities, проверить, что получен список активностей")
    public List<Activity> getActivitieList() {
        return given()
                .spec(getThreadQaSpec())
                .when()
                .get("/api/v1/Activities")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getList(".", Activity.class);
    }

    @Step("Найти в списке полученных активностей любую активность с номером 20+ и completed=false, проверить," +
            " что такая запись присутствует")
    public Activity checkActivitie(List<Activity> activityList) {
        for (Activity activity : activityList) {
            if (activity.id() > 20 && !activity.completed()) {
                return activity;
            }
        }
        return null;
    }
}
