package hw8.runtest;

import org.testng.annotations.Test;

import hw8.CoreTest;
import hw8.core.yandexspellerservice.YandexSpellerService;

import static hw8.core.yandexspellerservice.constants.TestText.*;
import static hw8.steps.assertionlayer.AssertionStepsCheckText.*;
import static hw8.core.yandexspellerservice.constants.TypeOfError.*;
import static hw8.core.yandexspellerservice.constants.Constants.Language.*;
import static hw8.core.yandexspellerservice.constants.Constants.URI_CHECK_TEXT;

public class CheckTextTest extends CoreTest {

    @Test(
            description = "check ignore wrong digits"
    )
    public void ignoreDigits() {
        YandexSpellerService
               .with(URI_CHECK_TEXT)
               .text(INPUT_TEXT_FOR_IGNORE_DIGITS)
               .language(EN)
               .options(ERROR_DIGITS.getNumber())
               .callApi()
               .then()
               .specification(checkThatBodyHasErrorCol(EXPECTED_TEXT_FOR_IGNORE_COL));
    }

    @Test(
            description = "check ignore capitalization"
    )
    public void ignoreCapitalization() {
        YandexSpellerService
                .with(URI_CHECK_TEXT)
                .text(INPUT_TEXT_FOR_CAP)
                .language(EN)
                .options(ERROR_CAPITALIZATION.getNumber())
                .callApi()
                .then()
                .specification(checkThatBodyHasErrorLen(EXPECTED_CODE_FOR_CAP));
    }

    @Test(
            description = "check text with wrong word"
    )
    public void checkWrongWord() {
        YandexSpellerService
                .with(URI_CHECK_TEXT)
                .text(INPUT_WORD)
                .language(EN)
                .callApi()
                .then()
                .specification(checkExistingWord(EXPECTED_WORD));
    }
}