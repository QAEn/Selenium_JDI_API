package hw8.steps.assertionlayer;

import io.restassured.http.ContentType;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.containsString;

public class AssertionStepsCheckText {

    public static ResponseSpecification checkExistingWord(String expectedWord) {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build()
                .expect()
                .body(containsString(expectedWord));
    }

    public static ResponseSpecification checkThatBodyHasErrorLen(String len) {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build()
                .expect()
                .body(containsString(len));
    }

    public static ResponseSpecification checkThatBodyHasErrorCol(String col) {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build()
                .expect()
                .body(containsString(col));
    }
}