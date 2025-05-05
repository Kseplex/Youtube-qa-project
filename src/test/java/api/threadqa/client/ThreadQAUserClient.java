package api.threadqa.client;

import api.threadqa.model.request.signup.User;
import api.threadqa.model.response.signup.CreateUserResponse;
import io.qameta.allure.Step;

import static api.Specifications.getThreadQaSpec;
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
