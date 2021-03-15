package hw8.steps.assertionlayer;

import io.restassured.http.ContentType;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.containsString;

public class AssertionStepsCheckTexts {

    public static ResponseSpecification expectedWordForIgnoreCapitalization(String expectedWord) {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build()
                .expect()
                .body(containsString(expectedWord));
    }

    public static ResponseSpecification expectedWordForeIgnoreDigits(String expectedWord) {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build()
                .expect()
                .body(containsString(expectedWord));
    }
}