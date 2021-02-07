package hw8.runtest;

import java.util.List;

import hw8.core.methods.CheckTexts;
import org.testng.annotations.Test;

import hw8.CoreTest;
import hw8.beans.YandexSpellerAnswer;
import hw8.core.methods.CheckText;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static hw8.core.constants.TypeOfError.*;
import static hw8.core.constants.Constants.Language.*;
import static hw8.core.methods.CheckTexts.successResponse;

public class CheckTextsApiTest extends CoreTest {

    @Test(description = "check ignore wrong capitalization")
    public void ignoreWrongCapitalization() {
        List<YandexSpellerAnswer> answers =
                CheckText.getYandexSpellerAnswers(
                        checkTextsApi.with()
                                .text("ThE world's largest manufacturer of custom software")
                                .language(EN)
                                .options(String.valueOf(3))
                                .callApi()
                                .then()
                                .specification(successResponse())
                                .extract()
                                .response()
                );

        assertThat(answers, hasSize(1));
        System.out.println("\n" + "\n" + answers.get(0).toString() + "\n" + "\n" + "\n");
        assertThat(answers.get(0).toString(), containsString("ThE"));
    }

    @Test(description = "check ignore digits")
    public void ignoreDigits() {
        List<List<YandexSpellerAnswer>> answers =
                CheckTexts.getYandexSpellerAnswers(
                        checkTextsApi.with()
                                .text("The world's largest 12manufacturer of custom software")
                                .language(EN)
                                .options(ERROR_DIGITALS.getNumber())
                                .callApi()
                                .then()
                                .specification(successResponse())
                                .extract().response());

        assertThat(answers, hasSize(2));
        //System.out.println("\n" + "\n" + answers.get(0).toString() + "\n" + "\n" + "\n");
        //assertThat(answers.get(0).toString(), containsString("Россxия"));
    }
}