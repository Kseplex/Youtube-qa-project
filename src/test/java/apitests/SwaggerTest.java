package apitests;


import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwaggerTest {
    private final static String URL = "http://85.192.34.140:8080/";
    private final Faker faker = new Faker();

    @Test
    public void userRegistrationTest(){
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK());
        Map<String, String> user = new HashMap<>();
        user.put("login", faker.name().username());
        user.put("pass", "12345");
        Response response = given()
                .body(user)
                .when()
                .post("/api/signup")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("id");
        assertTrue(id != 0);
    }
}
