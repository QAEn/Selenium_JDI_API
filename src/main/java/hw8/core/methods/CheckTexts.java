package hw8.core.methods;

import io.restassured.response.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import hw8.core.YandexSpellerCore;
import hw8.beans.YandexSpellerAnswer;

import java.util.List;

public class CheckTexts extends YandexSpellerCore {

    public CheckTexts() {
    }

    public ApiBuilder with() {
        CheckTexts checkTexts = new CheckTexts();
        return new ApiBuilder(checkTexts, getYandexSpellerCheckTextsApi);
    }

    public static List<YandexSpellerAnswer> getYandexSpellerAnswers(Response response) {
        return new Gson().fromJson(
                response.asString().trim(), new TypeToken<List<YandexSpellerAnswer>>() {}.getType()
        );
    }

}