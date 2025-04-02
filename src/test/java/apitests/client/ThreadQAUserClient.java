package apitests.client;

import apitests.model.request.signup.User;
import apitests.model.response.signup.CreateUserResponse;
import io.qameta.allure.Step;

import static apitests.Specifications.getThreadQaSpec;
import static io.restassured.RestAssured.given;

public class ThreadQAUserClient {

    @Step("Вызвать метод POST сервиса user-controller-new /api/signup с телом {0}")
    public CreateUserResponse signUp(User user){
        return given()
                .spec(getThreadQaSpec())
                .body(user)
                .log().all()
                .when()
                .post("/api/signup")
                .then()
                .log().all()
                .statusCode(201)
                .extract().as(CreateUserResponse.class);
    }


}
