package hw8.utility;

import static java.lang.Integer.parseInt;

import static hw8.utility.GetProperties.NameOfProperty.*;

public class ReaderOfTestData {

    protected GetProperties getTestData = new GetProperties(TEST_DATA);

    protected String inputTextForeIgnoreDigits = getTestData
            .getTestData("inputTextForeIgnoreDigits");
    protected String expectedTextForeIgnoreDigits = getTestData
            .getTestData("expectedTextForeIgnoreDigits");
    protected int expectedTextForeIgnoreCode = parseInt(getTestData
            .getTestData("expectedTextForeIgnoreCode"));
    protected int expectedTextForeIgnorePos = parseInt(getTestData
            .getTestData("expectedTextForeIgnorePos"));
    protected int expectedTextForeIgnoreRow = parseInt(getTestData
            .getTestData("expectedTextForeIgnoreRow"));
    protected int expectedTextForeIgnoreCol = parseInt(getTestData
            .getTestData("expectedTextForeIgnoreCol"));
    protected int expectedTextForeIgnoreLen = parseInt(getTestData
            .getTestData("expectedTextForeIgnoreLen"));

    protected String inputTextForeIgnoreCapitalization = getTestData
            .getTestData("inputTextForeIgnoreCapitalization");
    protected int expectedLenForeIgnoreCapitalization = parseInt(getTestData
            .getTestData("expectedLenForeIgnoreCapitalization"));
    protected int expectedCapitalizationHasSize = parseInt(getTestData
            .getTestData("expectedCapitalizationHasSize"));

    protected String correctWord = getTestData
            .getTestData("correctWord");
    protected String incorrectWord = getTestData
            .getTestData("incorrectWord");
    protected int expectedCodeForWrongWord = parseInt(getTestData
            .getTestData("expectedCodeForWrongWord"));

    protected String expectedWordForeIgnoreCapitalization = getTestData
            .getTestData("expectedWordForeIgnoreCapitalization");
    protected String expectedWordForeIgnoreDigits = getTestData
            .getTestData("expectedWordForeIgnoreDigits");
}