package hw8.core.yandexspellerservice;

import java.util.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import hw8.core.CommonApi;
import hw8.beans.YandexSpellerAnswer;
import hw8.core.yandexspellerservice.constants.Constants;

import static hw8.core.yandexspellerservice.constants.Constants.*;

public class YandexSpellerService extends CommonApi {

    public YandexSpellerService() {
    }

    public HashMap<String, String> params = new HashMap<>();

    public static class ApiBuilder {
        YandexSpellerService yandexSpellerService;
        String uri;

        private ApiBuilder(YandexSpellerService yandexSpellerService, String uri) {
            this.yandexSpellerService = yandexSpellerService;
            this.uri = uri;
        }

        public ApiBuilder text(String text) {
            yandexSpellerService.params.put(PARAM_TEXT, text);
            return this;
        }

        public ApiBuilder options(String options) {
            yandexSpellerService.params.put(PARAM_OPTIONS, options);
            return this;
        }

        public ApiBuilder language(Constants.Language language) {
            yandexSpellerService.params.put(PARAM_LANG, language.languageCode);
            return this;
        }

        public Response callApi() {
            return RestAssured.with()
                    .queryParams(yandexSpellerService.params)
                    .log().all()
                    .get(uri).prettyPeek();
        }
    }

        public static ApiBuilder with(String uri) {
            YandexSpellerService yandexSpeller = new YandexSpellerService();
            return new ApiBuilder(yandexSpeller, URL + uri);
        }

        public static List<YandexSpellerAnswer> getYandexSpellerAnswers(Response response) {
            return new Gson().fromJson(
                 response.asString().trim(), new TypeToken<List<YandexSpellerAnswer>>() {}.getType()
            );
        }
}