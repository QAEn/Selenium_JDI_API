package hw8.runtest;

import org.testng.annotations.Test;

import hw8.dataprovider.DataProviderForTests;
import hw8.CoreTest;

import static hw8.core.constants.TypeOfError.*;
import static hw8.core.constants.Constants.Language.*;
import static hw8.core.methods.CheckTexts.successResponse;

public class CheckTextsApiTest extends CoreTest {

    @Test(
            description = "check ignore capitalization",
            dataProvider = "TestDataForCapitalizationOfMethodCheckTexts",
            dataProviderClass = DataProviderForTests.class
    )
    public void ignoreCapitalization(String inputTextForeIgnoreCapitalization,
                                     String expectedWordForeIgnoreCapitalization) {
        checkTextsApi
                .with()
                .text(inputTextForeIgnoreCapitalization)
                .language(EN)
                .options(ERROR_CAPITALIZATION.getNumber())
                .callApi()
                .then()
                .specification(successResponse(expectedWordForeIgnoreCapitalization));
    }

    @Test(
            description = "check ignore digits",
            dataProvider = "TestDataForDigitsOfMethodCheckTexts",
            dataProviderClass = DataProviderForTests.class
    )
    public void ignoreDigits(String inputTextForeIgnoreDigits,
                             String expectedWordForeIgnoreDigits) {
        checkTextsApi
                .with()
                .text(inputTextForeIgnoreDigits)
                .language(EN)
                .options(ERROR_DIGITS.getNumber())
                .callApi()
                .then()
                .specification(successResponse(expectedWordForeIgnoreDigits));
    }
}