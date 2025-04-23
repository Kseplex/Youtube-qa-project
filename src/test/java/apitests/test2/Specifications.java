package apitests.test2;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specifications {

    private static final String BASE_THREAD_QA_URL = "https://fakerestapi.azurewebsites.net";

    public static RequestSpecification getThreadQaSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_THREAD_QA_URL)
                .build();
    }

}