package api.fakerestapi.client;

import api.fakerestapi.model.Activity;
import io.qameta.allure.Step;

import java.util.List;

import static api.Specifications.getFakeRestApiSpec;
import static io.restassured.RestAssured.given;

public class FakeRestApiActivityClient {

    @Step("Вызвать метод Get api/v1/activities, проверить, что получен список активностей")
    public List<Activity> getActivitiesList() {
        return given()
                .spec(getFakeRestApiSpec())
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
                .spec(getFakeRestApiSpec())
                .when()
                .get(String.format("/api/v1/Activities/%d", id))
                .then()
                .statusCode(200)
                .extract().as(Activity.class);
    }
}
