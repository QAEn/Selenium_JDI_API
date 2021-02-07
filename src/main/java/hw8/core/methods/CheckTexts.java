package hw8.core.methods;

import java.util.List;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import org.apache.http.HttpStatus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import hw8.core.YandexSpellerCore;
import hw8.beans.YandexSpellerAnswer;

public class CheckTexts extends YandexSpellerCore {

    private String uri = getProperties
            .getUri("yandexSpellerCheckTextsURI");

    public CheckTexts() {
    }

    public ApiBuilder with() {
        CheckTexts checkTexts = new CheckTexts();
        return new ApiBuilder(checkTexts, url + uri);
    }

    public static List<List<YandexSpellerAnswer>> getYandexSpellerAnswers(Response response) {
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