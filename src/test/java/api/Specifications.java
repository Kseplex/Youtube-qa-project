package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specifications {

    private static final String BASE_THREAD_QA_URL = "http://85.192.34.140:8080";
    private static final String FAKE_REST_API_URL = "https://fakerestapi.azurewebsites.net";

    public static RequestSpecification getThreadQaSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_THREAD_QA_URL)
                .build();
    }

    public static RequestSpecification getFakeRestApiSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(FAKE_REST_API_URL)
                .build();
    }

}
