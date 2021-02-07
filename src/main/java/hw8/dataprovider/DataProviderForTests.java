package hw8.dataprovider;

import hw8.utility.GetProperties;

import org.testng.annotations.DataProvider;

import static java.lang.Integer.parseInt;

import static hw8.utility.GetProperties.NameOfProperty.TEST_DATA;

public class DataProviderForTests {

    private GetProperties getTestData = new GetProperties(TEST_DATA);

    private String inputTextForeIgnoreDigits = getTestData
            .getTestData("inputTextForeIgnoreDigits");
    private String expectedTextForeIgnoreDigits = getTestData
            .getTestData("expectedTextForeIgnoreDigits");
    private int expectedTextForeIgnoreCode = parseInt(getTestData
            .getTestData("expectedTextForeIgnoreCode"));
    private int expectedTextForeIgnorePos = parseInt(getTestData
            .getTestData("expectedTextForeIgnorePos"));
    private int expectedTextForeIgnoreRow = parseInt(getTestData
            .getTestData("expectedTextForeIgnoreRow"));
    private int expectedTextForeIgnoreCol = parseInt(getTestData
            .getTestData("expectedTextForeIgnoreCol"));
    private int expectedTextForeIgnoreLen = parseInt(getTestData
            .getTestData("expectedTextForeIgnoreLen"));

    private String inputTextForeIgnoreCapitalization = getTestData
            .getTestData("inputTextForeIgnoreCapitalization");
    private int expectedLenForeIgnoreCapitalization = parseInt(getTestData
            .getTestData("expectedLenForeIgnoreCapitalization"));
    private int expectedCapitalizationHasSize = parseInt(getTestData
            .getTestData("expectedCapitalizationHasSize"));

    private String correctWord = getTestData
            .getTestData("correctWord");
    private String incorrectWord = getTestData
            .getTestData("incorrectWord");
    private int expectedCodeForWrongWord = parseInt(getTestData
            .getTestData("expectedCodeForWrongWord"));

    @DataProvider(name = "TestDataForIgnoreDigits")
    public Object[][] assertTestDataForIgnoreDigits() {
        return new Object[][]{
                {       inputTextForeIgnoreDigits, expectedTextForeIgnoreDigits,
                        expectedTextForeIgnoreCode, expectedTextForeIgnorePos,
                        expectedTextForeIgnoreRow, expectedTextForeIgnoreCol,
                        expectedTextForeIgnoreLen
                }
        };
    }

    @DataProvider(name = "TestDataForCapitalization")
    public Object[][] assertTestDataForIgnoreCapitalization() {
        return new Object[][]{
                {       inputTextForeIgnoreCapitalization,
                        expectedLenForeIgnoreCapitalization,
                        expectedCapitalizationHasSize
                }
        };
    }

    @DataProvider(name = "TestDataForCheckWrongWord")
    public Object[][] assertTextDataSet() {
        return new Object[][]{
                {correctWord, incorrectWord, expectedCodeForWrongWord}
        };
    }
}