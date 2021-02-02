package hw8.core.constants;

import hw8.utility.ReaderOfTestData;

public class SetTextData extends ReaderOfTestData {
    
    private static String firstRussianCorrectWord;
    private static String firstRussianWrongWord;

    private static String secondRussianCorrectWord;
    private static String secondRussianWrongWord;
    
    private static String correctCapitalizationRussianWord;
    private static String wrongCapitalizationRussianWord;

    private static String englishWordWithoutDigits;
    private static String englishWordWithDigits;

public enum TestText {

    FIRST_RUS_WORD(firstRussianCorrectWord, firstRussianWrongWord),

    SECOND_RUS_WORD(secondRussianCorrectWord, secondRussianWrongWord),

    RUS_WRONG_CAPITAL(correctCapitalizationRussianWord, wrongCapitalizationRussianWord),

    ENG_WORD_WITH_DIGITS(englishWordWithoutDigits, englishWordWithDigits);

    private String correctTestData;
    private String wrongTestData;

    public String getCorrectData() {
        return correctTestData;
    }

    public String getWrongData() {
        return wrongTestData;
    }

    TestText(String correct, String wrong) {
        correctTestData = correct;
        wrongTestData = wrong;
    }
}

    public SetTextData(SetTextData.TestText testTextEnum) {
        switch (testTextEnum) {
            case FIRST_RUS_WORD:
                firstRussianCorrectWord = firstRusCorrectWord;
                firstRussianWrongWord = firstRusWrongWord;
                break;

            case SECOND_RUS_WORD:
                secondRussianCorrectWord = secondRusCorrectWord;
                secondRussianWrongWord = secondRusWrongWord;
                break;

            case RUS_WRONG_CAPITAL:
                correctCapitalizationRussianWord = correctCapitalizationRusWord;
                wrongCapitalizationRussianWord = wrongCapitalizationRusWord;
                break;

            case ENG_WORD_WITH_DIGITS:
                englishWordWithoutDigits = engWordWithoutDigits;
                englishWordWithDigits = engWordWithDigits;
                break;

            default:
                System.err.println("The text wasn't set");
                break;
        }
    }
}