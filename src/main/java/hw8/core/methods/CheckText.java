package hw8.core.methods;

import java.util.*;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import org.apache.http.HttpStatus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import hw8.core.YandexSpellerCore;
import hw8.beans.YandexSpellerAnswer;

public class CheckText extends YandexSpellerCore {

    private String uri = getProperties
            .getUri("yandexSpellerCheckTextURI");

    public CheckText() {
    }

    public ApiBuilder with() {
        CheckText checkText = new CheckText();
        return new ApiBuilder(checkText, url + uri);
    }

    public static List<YandexSpellerAnswer> getYandexSpellerAnswers(Response response) {
        return new Gson().fromJson(
                response.asString().trim(), new TypeToken<List<YandexSpellerAnswer>>() {}.getType()
        );
    }

    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }
}