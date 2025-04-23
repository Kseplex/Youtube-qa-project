package apitests.test2.client;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static apitests.test2.Specifications.getThreadQaSpec;
import static io.restassured.RestAssured.given;

public class ThreadQAActivities {

    @Step("Вызвать метод GET сервиса fakerestapi /api/v1/Activities")
    public void getActivities(){
        Response response = given()
                .spec(getThreadQaSpec())
                .when()
                .get("/api/v1/Activities")
                .then()
                .statusCode(200)
                .extract().response();
    }
}
