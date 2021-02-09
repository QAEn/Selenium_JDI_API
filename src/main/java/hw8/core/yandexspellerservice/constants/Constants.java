package hw8.core.yandexspellerservice.constants;

public class Constants {

    public static final String URL = "https://speller.yandex.net/services/spellservice.json/";

    public static final String URI_CHECK_TEXT = "checkText";
    public static final String URI_CHECK_TEXTS = "checkTexts";

    public static final String PARAM_TEXT = "text";
    public static final String PARAM_OPTIONS = "options";
    public static final String PARAM_LANG = "lang";

    public enum Language {
        EN("en");

        public String languageCode;

        Language(String lang) {
            this.languageCode = lang;
        }
    }
}