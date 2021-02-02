package hw8.runtest;

import java.util.List;

import org.testng.annotations.Test;

import hw8.CoreTest;
import hw8.beans.YandexSpellerAnswer;
import hw8.core.methods.CheckText;
import hw8.core.constants.SetTextData;
import hw8.core.constants.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static hw8.core.methods.CheckText.successResponse;
import static hw8.core.constants.SetTextData.TestText.*;
import static hw8.core.constants.TypeOfError.*;

public class CheckTextApiTest extends CoreTest {

    @Test(description = "check ignore wrong capitalization")
    public void ignoreWrongCapitalization() {
        List<YandexSpellerAnswer> answers =
                CheckText.getYandexSpellerAnswers(
                        checkTextApi.with()
                                .text(RUS_WRONG_CAPITAL.getWrongData())
                                .options(ERROR_CAPITALIZATION.getNumber())
                                .callApi());
        assertThat("expected number of answers is wrong.", answers.size(), equalTo(0));
    }

    @Test(description = "check ignore digits")
    public void ignoreDigits() {
        List<YandexSpellerAnswer> answers =
                CheckText.getYandexSpellerAnswers(
                        checkTextApi.with()
                                .text(ENG_WORD_WITH_DIGITS.getWrongData())
                                .options(ERROR_DIGITS.getNumber())
                                .callApi());
        assertThat("expected number of answers is wrong.", answers.size(), equalTo(0));
    }

    @Test(description = "check text with wrong language")
    public void checkTextWithWrongLanguage() {
        List<YandexSpellerAnswer> answers =
                CheckText.getYandexSpellerAnswers(
                        checkTextApi.with()
                                .text(FIRST_RUS_WORD.getWrongData() + ", "
                                    + SECOND_RUS_WORD.getWrongData())
                                .language(Constants.Language.RU)
                                .callApi()
                                .then()
                                .specification(successResponse())
                                .extract().response());

        assertThat(answers, hasSize(1));
        assertThat(answers.get(0).toString(), containsString(
                SetTextData.TestText.SECOND_RUS_WORD.getCorrectData())
        );
    }
}