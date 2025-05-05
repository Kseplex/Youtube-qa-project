package apitests.test2.client;

import apitests.test2.request.activities.Activity;
import io.qameta.allure.Step;

import java.util.List;

import static apitests.test2.Specifications.getThreadQaSpec;
import static io.restassured.RestAssured.given;

public class ThreadQAActivityClient {

    @Step("Вызвать метод Get api/v1/activities, проверить, что получен список активностей")
    public List<Activity> getActivitiesList() {
        return given()
                .spec(getThreadQaSpec())
                .when()
                .get("/api/v1/Activities")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Activity.class);
    }

    @Step("Вызываем метод Get api/v1/activities/{id}, где id = id активности из предыдущего шага")
    public Activity getActivityById(Integer id) {
        return given()
                .spec(getThreadQaSpec())
                .when()
                .get(String.format("/api/v1/Activities/%d", id))
                .then()
                .statusCode(200)
                .extract().as(Activity.class);
    }
}
