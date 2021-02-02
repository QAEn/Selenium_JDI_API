package hw8.utility;

import static hw8.utility.GetProperties.NameOfProperty.*;

public class ReaderOfTestData {

    private GetProperties getTestDataProperties = new GetProperties(TEST_DATA);
    private GetProperties getUriProperties = new GetProperties(URI);

    protected String getYandexSpellerCheckTextApi = getUriProperties
            .getUri("yandexSpellerCheckTextAPI");
    protected String getYandexSpellerCheckTextsApi = getUriProperties
            .getUri("yandexSpellerCheckTextsAPI");

    protected String firstRusCorrectWord = getTestDataProperties
            .getTestData("firstRusCorrectWord");
    protected String firstRusWrongWord = getTestDataProperties
            .getTestData("firstRusWrongWord");

    protected String secondRusCorrectWord = getTestDataProperties
                    .getTestData("secondRusCorrectWord");
    protected String secondRusWrongWord = getTestDataProperties
                    .getTestData("secondRusWrongWord");

    protected String correctCapitalizationRusWord = getTestDataProperties
                    .getTestData("correctCapitalizationRusWord");
    protected String wrongCapitalizationRusWord = getTestDataProperties
                    .getTestData("wrongCapitalizationRusWord");

    protected String engWordWithoutDigits = getTestDataProperties
            .getTestData("engWordWithoutDigits");
    protected String engWordWithDigits = getTestDataProperties
            .getTestData("engWordWithDigits");
}