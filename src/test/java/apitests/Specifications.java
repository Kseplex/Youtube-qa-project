package apitests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specifications {

    private static final String BASE_THREAD_QA_URL = "http://85.192.34.140:8080";

    public static RequestSpecification getThreadQaSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_THREAD_QA_URL)
                .build();
    }

}
