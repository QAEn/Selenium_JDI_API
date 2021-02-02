package hw8.core.constants;

public class Constants {

    public static final String PARAM_TEXT = "text";
    public static final String PARAM_OPTIONS = "options";
    public static final String PARAM_LANG = "lang";

    public enum Language {

        RU("ru"),
        EN("en");

        public String languageCode;

        Language(String lang) {
            this.languageCode = lang;
        }
    }
}