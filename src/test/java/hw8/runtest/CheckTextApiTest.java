package hw8.runtest;

import java.util.List;

import org.testng.annotations.Test;

import hw8.dataprovider.DataProviderForTests;
import hw8.steps.assertionlayer.CheckerOfAnswers;
import hw8.CoreTest;
import hw8.beans.YandexSpellerAnswer;
import hw8.core.methods.CheckText;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static hw8.core.constants.Constants.Language.*;
import static hw8.core.methods.CheckText.successResponse;
import static hw8.core.constants.TypeOfError.*;

public class CheckTextApiTest extends CoreTest {

    @Test(
            description = "check ignore wrong digits",
            dataProvider = "TestDataForIgnoreDigits",
            dataProviderClass = DataProviderForTests.class
    )
    public void ignoreDigits(String inputTextForeIgnoreDigits,
                             String expectedTextForeIgnoreDigits,
                             int expectedTextForeIgnoreCode,
                             int expectedTextForeIgnorePos,
                             int expectedTextForeIgnoreRow,
                             int expectedTextForeIgnoreCol,
                             int expectedTextForeIgnoreLen) {
        List<YandexSpellerAnswer> answer =
                CheckText.getYandexSpellerAnswers(
                        checkTextApi
                                .with()
                                .text(inputTextForeIgnoreDigits)
                                .language(EN)
                                .options(ERROR_DIGITALS.getNumber())
                                .callApi()
                                .then()
                                .specification(successResponse())
                                .extract()
                                .response()
                );

        checkerOfAnswers = new CheckerOfAnswers(answer)
                .checkThatBodyHasErrorCode(expectedTextForeIgnoreCode)
                .checkThatBodyHasErrorPos(expectedTextForeIgnorePos)
                .checkThatBodyHasErrorRow(expectedTextForeIgnoreRow)
                .checkThatBodyHasErrorCol(expectedTextForeIgnoreCol)
                .checkThatBodyHasErrorLen(expectedTextForeIgnoreLen)
                .checkThatWordWithErrorExistsAtAnswer(expectedTextForeIgnoreDigits);

    }

    @Test(
            description = "check ignore capitalization",
            dataProvider = "TestDataForCapitalization",
            dataProviderClass = DataProviderForTests.class
    )
    public void ignoreCapitalization(String inputTextForeIgnoreCapitalization,
                                     int expectedLenForeIgnoreCapitalization,
                                     int expectedCapitalizationHasSize) {
        List<YandexSpellerAnswer> answer =
                CheckText.getYandexSpellerAnswers(
                        checkTextApi
                                .with()
                                .text(inputTextForeIgnoreCapitalization)
                                .language(EN)
                                .options(ERROR_CAPITALIZATION.getNumber())
                                .callApi()
                                .then()
                                .specification(successResponse())
                                .extract()
                                .response()
                );

        assertThat(answer, hasSize(expectedCapitalizationHasSize));
        checkerOfAnswers = new CheckerOfAnswers(answer)
                .checkThatBodyHasErrorLen(expectedLenForeIgnoreCapitalization);

    }

    @Test(
            description = "check text with wrong word",
            dataProvider = "TestDataForCheckWrongWord",
            dataProviderClass = DataProviderForTests.class
    )
    public void checkWrongWord(String correctWord, String incorrectWord,
                               int expectedCodeForWrongWord) {
        List<YandexSpellerAnswer> answer =
                CheckText.getYandexSpellerAnswers(
                        checkTextApi
                                .with()
                                .text(incorrectWord + ", " + correctWord)
                                .language(EN)
                                .callApi()
                                .then()
                                .specification(successResponse())
                                .extract()
                                .response()
                );

        checkerOfAnswers = new CheckerOfAnswers(answer)
                .checkThatBodyHasErrorCode(expectedCodeForWrongWord);
    }
}