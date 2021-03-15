package hw8.runtest;

import org.testng.annotations.Test;

import hw8.CoreTest;
import hw8.core.yandexspellerservice.YandexSpellerService;

import static hw8.core.yandexspellerservice.constants.TestText.*;
import static hw8.core.yandexspellerservice.constants.TypeOfError.*;
import static hw8.core.yandexspellerservice.constants.Constants.Language.*;
import static hw8.steps.assertionlayer.AssertionStepsCheckTexts.expectedWordForeIgnoreDigits;
import static hw8.steps.assertionlayer.AssertionStepsCheckTexts.expectedWordForIgnoreCapitalization;
import static hw8.core.yandexspellerservice.constants.Constants.URI_CHECK_TEXTS;

public class CheckTextsTest extends CoreTest {

    @Test(
            description = "check ignore capitalization"
    )
    public void ignoreCapitalization() {
        YandexSpellerService
                .with(URI_CHECK_TEXTS)
                .text(INPUT_WORD_FOR_IGNORE_CAP)
                .language(EN)
                .options(ERROR_CAPITALIZATION.getNumber())
                .callApi()
                .then()
                .specification(expectedWordForIgnoreCapitalization(EXPECTED_WORD_FOR_IGNORE_CAP));
    }

    @Test(
            description = "check ignore digits"
    )
    public void ignoreDigits() {
        YandexSpellerService
                .with(URI_CHECK_TEXTS)
                .text(INPUT_TEXT_FOR_IGNORE_DIGITS)
                .language(EN)
                .options(ERROR_DIGITS.getNumber())
                .callApi()
                .then()
                .specification(expectedWordForeIgnoreDigits(EXPECTED_WORD_FOR_IGNORE_DIG));
    }
}