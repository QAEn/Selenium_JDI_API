package hw8.dataprovider;

import org.testng.annotations.DataProvider;

import hw8.utility.ReaderOfTestData;

public class DataProviderForTests extends ReaderOfTestData {

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

    @DataProvider(name = "TestDataForCapitalizationOfMethodCheckTexts")
    public Object[][] testDataForCapitalizationOfMethodCheckTexts() {
        return new Object[][]{
                {       inputTextForeIgnoreCapitalization,
                        expectedWordForeIgnoreCapitalization}
        };
    }

    @DataProvider(name = "TestDataForDigitsOfMethodCheckTexts")
    public Object[][] testDataForDigitsOfMethodCheckTexts() {
        return new Object[][]{
                {       inputTextForeIgnoreDigits,
                        expectedWordForeIgnoreDigits}
        };
    }
}