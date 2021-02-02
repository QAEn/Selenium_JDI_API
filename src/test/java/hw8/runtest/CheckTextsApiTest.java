package hw8.runtest;

import java.util.List;

import org.testng.annotations.Test;

import hw8.CoreTest;
import hw8.beans.YandexSpellerAnswer;
import hw8.core.methods.CheckText;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static hw8.core.constants.TypeOfError.*;
import static hw8.core.constants.SetTextData.TestText.*;

public class CheckTextsApiTest extends CoreTest {

    @Test(description = "")
    public void ignoreWrongCapitalization() {
        List<YandexSpellerAnswer> answers =
                CheckText.getYandexSpellerAnswers(
                        checkTextApi.with()
                                .text(RUS_WRONG_CAPITAL.getWrongData())
                                .options(ERROR_CAPITALIZATION.getNumber())
                                .callApi());
        assertThat("expected number of answers is wrong.", answers.size(), equalTo(0));
    }

    @Test(description = "")
    public void ignoreDigits() {
        List<YandexSpellerAnswer> answers =
                CheckText.getYandexSpellerAnswers(
                        checkTextApi.with()
                                .text(ENG_WORD_WITH_DIGITS.getWrongData())
                                .options(ERROR_DIGITS.getNumber())
                                .callApi());
        assertThat("expected number of answers is wrong.", answers.size(), equalTo(0));
    }
}