package hw8.core;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import hw8.utility.ReaderOfTestData;

import static hw8.core.constants.Constants.*;

public class YandexSpellerCore extends ReaderOfTestData {

    private HashMap<String, String> params = new HashMap<String, String>();

    public class ApiBuilder { //параметры при вызове апи
        YandexSpellerCore yandexSpellerCore;
        String nameOfApiMethod;

        public ApiBuilder(YandexSpellerCore yandexSpellerCore, String nameOfApiMethod) {
            this.yandexSpellerCore = yandexSpellerCore;
            this.nameOfApiMethod = nameOfApiMethod;
        }

        public ApiBuilder text(String text) {
            yandexSpellerCore.params.put(PARAM_TEXT, text);
            return this;
        }

        public ApiBuilder options(String options) {
            yandexSpellerCore.params.put(PARAM_OPTIONS, options);
            return this;
        }

        public ApiBuilder language(Language language) {
            yandexSpellerCore.params.put(PARAM_LANG, language.languageCode);
            return this;
        }

        public Response callApi() {
            return RestAssured.with()
                    .queryParams(yandexSpellerCore.params)
                    .log().all()
                    .get(nameOfApiMethod).prettyPeek();
        }
    }
}